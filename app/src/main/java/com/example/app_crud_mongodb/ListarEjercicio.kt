package com.example.app_crud_mongodb

import EjercicioAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_crud_mongodb.API.Ejercicios
import com.example.app_crud_mongodb.API.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import androidx.recyclerview.widget.RecyclerView

class ListarEjercicio : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout._listarejercicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val rv = findViewById<RecyclerView>(R.id.recyclerEjercicios)
        rv.layoutManager = LinearLayoutManager(this)

        // Llamada a la API para listar un ejercicio
        RetrofitClient.instance.listarEjercicio().enqueue(object : retrofit2.Callback<List<Ejercicios>> {
            override fun onResponse(
                p0: Call<List<Ejercicios>>,
                res: Response<List<Ejercicios>>)
            {
                if (res.isSuccessful) {
                    val lista = res.body()
                    println("EJercicios: $lista")
                    rv.adapter = EjercicioAdapter(lista ?: emptyList())
                } else {
                    println("Error: ${res.code()}")
                }
            }
            override fun onFailure(call: Call<List<Ejercicios>>, t: Throwable) {
                t.printStackTrace()
            }
        })




        // Botón para volver al menú principal
        val volver = findViewById<Button>(R.id.volver)
        volver.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }


}