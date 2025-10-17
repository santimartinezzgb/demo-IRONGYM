package com.example.app_crud_mongodb

import EjercicioAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_crud_mongodb.API.Ejercicios
import com.example.app_crud_mongodb.API.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ZonaCliente : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.zonacliente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.zona_cliente)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón para volver
        findViewById<Button>(R.id.volver).setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

        // Botón para añadir un ejercicio
        findViewById<Button>(R.id.btnAddEjercicio).setOnClickListener {
            startActivity(Intent(this, AnadirEjercicio::class.java))
        }

        // RecyclerView para mostrar ejercicios guardados en mi base de datos
        val variableRecyclerView = findViewById<RecyclerView>(R.id.recyclerEjercicios)
        variableRecyclerView.layoutManager = LinearLayoutManager(this)

        // Llama a la API
        RetrofitClient.instance.listarEjercicio().enqueue(object : Callback<List<Ejercicios>> {
            override fun onResponse(
                call: Call<List<Ejercicios>>,
                res: Response<List<Ejercicios>>
            ) {
                    val lista = res.body() ?: emptyList()

                    variableRecyclerView.adapter = EjercicioAdapter(
                        lista,
                        onEditarClick = { ejercicio ->
                            val intent = Intent(this@ZonaCliente, AnadirEjercicio::class.java)
                            intent.putExtra("idEjercicio", ejercicio._id)
                            intent.putExtra("nombre", ejercicio.nombre)
                            intent.putExtra("peso", ejercicio.peso)
                            intent.putExtra("series", ejercicio.series)
                            intent.putExtra("repeticiones", ejercicio.repeticiones)
                            startActivity(intent)
                        }
,
                        onEliminarClick = { ejercicio ->
                            Toast.makeText(this@ZonaCliente, "Ejercicio eliminado con éxito", Toast.LENGTH_SHORT).show()
                            RetrofitClient.instance.eliminarEjercicio(ejercicio._id)
                                .enqueue(object : Callback<Void> {
                                    override fun onResponse(c: Call<Void>, r: Response<Void>) {
                                        this@ZonaCliente.recreate()
                                    }
                                    override fun onFailure(c: Call<Void>, t: Throwable) {
                                        t.printStackTrace()
                                    }
                                })
                        }
                    )

            }

            override fun onFailure(call: Call<List<Ejercicios>>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
}
