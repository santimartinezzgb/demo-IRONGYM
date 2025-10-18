package com.example.app_crud_mongodb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_crud_mongodb.API.Ejercicio
import com.example.app_crud_mongodb.API.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
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

        // Botón para volver
        val volver = findViewById<Button>(R.id.volver)
        volver.setOnClickListener {
            val intent = Intent(this, ZonaCliente::class.java)
            startActivity(intent)
        }


        val btnEnviar = findViewById<Button>(R.id.btnanadir)
        var nombreEjercicio = findViewById<EditText>(R.id.nombre_ejercicio)
        var pesoEjercicio = findViewById<EditText>(R.id.peso)
        var seriesEjercicio = findViewById<EditText>(R.id.series_ejercicio)
        var repeticionesEjercicio = findViewById<EditText>(R.id.repeticiones_ejercicio)


        val idEjercicio = intent.getStringExtra("idEjercicio")
        if (idEjercicio != null) {
            btnEnviar.text = "Guardar"

            // getStringExtra() busca un dato que fue agregado antes con la clase "nombre"
            var nombre = intent.getStringExtra("nombre")
            var peso = intent.getStringExtra("peso")
            var series = intent.getStringExtra("series")
            var repeticiones = intent.getStringExtra("repeticiones")

            nombreEjercicio.setText(nombre)
            pesoEjercicio.setText(peso)
            seriesEjercicio.setText(series)
            repeticionesEjercicio.setText(repeticiones)
        }

        btnEnviar.setOnClickListener {

            val ejercicio = Ejercicio(
                _id= idEjercicio,
                nombre = nombreEjercicio.text.toString().uppercase(),
                peso = pesoEjercicio.text.toString(),
                series = seriesEjercicio.text.toString(),
                repeticiones = repeticionesEjercicio.text.toString()
            )

            val call: Call<Ejercicio> = if (idEjercicio != null) {

                Toast.makeText(this@AnadirEjercicio, "Ejercicio editado con éxito", Toast.LENGTH_SHORT).show()
                RetrofitClient.instance.editarEjercicio(idEjercicio, ejercicio)

            } else {
                Toast.makeText(this@AnadirEjercicio, "Ejercicio creado con éxito", Toast.LENGTH_SHORT).show()
                RetrofitClient.instance.crearEjercicio(ejercicio)
            }


            // Enqueue() lanza la petición en segundo plano y manda los resultados a través
            // de dos métodos del Callback
            call.enqueue(object : Callback<Ejercicio> {

                // Se ejecuta cuando la API responde correctamente
                override fun onResponse(call: Call<Ejercicio>, response: Response<Ejercicio>) {
                    if(response.isSuccessful){
                        Log.d("API", "Recibidos: $ejercicio")
                    } else {
                        Log.e("API", "Error HTTP: ${response.code()}")
                    }
                }

                // Se ejecuta su hubo un error de red, o el parseo de datos no pudo hacerse
                override fun onFailure(call: Call<Ejercicio>, t: Throwable) {
                    Log.e("API", "Fallo de red: ${t.message}")
                    t.printStackTrace()
                }
            })

            nombreEjercicio.setText("");
            pesoEjercicio.setText("")
            seriesEjercicio.setText("")
            repeticionesEjercicio.setText("")
        }
    }
}
