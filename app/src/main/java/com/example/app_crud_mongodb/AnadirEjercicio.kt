package com.example.app_crud_mongodb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_crud_mongodb.API.Ejercicios
import com.example.app_crud_mongodb.API.RetrofitClient
import retrofit2.Call
import retrofit2.Response


class AnadirEjercicio : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout._anadirejercicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.anadir)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val volver = findViewById<Button>(R.id.volver)
        volver.setOnClickListener {
            val intent = Intent(this, ZonaCliente::class.java)
            startActivity(intent)
        }


        val btnEnviar = findViewById<Button>(R.id.btnanadir)
        val nombre_ejercicio = findViewById<EditText>(R.id.nombre_ejercicio)
        val grupo_muscular = findViewById<EditText>(R.id.grupo_muscular)
        val series_ejercicio = findViewById<EditText>(R.id.series_ejercicio)
        val repeticiones_ejercicio = findViewById<EditText>(R.id.repeticiones_ejercicio)

        btnEnviar.setOnClickListener {
            val nombre = nombre_ejercicio.text.toString()
            val grupo = grupo_muscular.text.toString()
            val series = series_ejercicio.text.toString()
            val repeticiones = repeticiones_ejercicio.text.toString()

            val nuevoEjercicio = Ejercicios(null, nombre, grupo, series, repeticiones)

            RetrofitClient.instance.crearEjercicio(nuevoEjercicio)
                .enqueue(object : retrofit2.Callback<Ejercicios> {

                    override fun onResponse(
                        call: Call<Ejercicios>,
                        response: Response<Ejercicios>) {

                        if (response.isSuccessful) {
                            println("Ejercicio guardado: ${response.body()}")
                            nombre_ejercicio.setText("")
                            grupo_muscular.setText("")
                            series_ejercicio.setText("")
                            repeticiones_ejercicio.setText("")
                        } else {
                            println("Error en el guardado: ${response.code()}")
                        }
                    }

                    override fun onFailure(call: Call<Ejercicios>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
        }
    }


}

