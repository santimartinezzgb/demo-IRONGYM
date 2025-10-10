package com.example.app_crud_mongodb

import com.example.app_crud_mongodb.API.Ejercicios
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_crud_mongodb.API.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class CRUD : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_5_addejercicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addejercicio)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Llamada a la API para crear un ejercicio
        RetrofitClient.instance.crearEjercicio().enqueue(object : retrofit2.Callback<List<Ejercicios>> {
            override fun onResponse(p0: Call<List<Ejercicios>>, res: Response<List<Ejercicios>>) {
                if (res.isSuccessful) {
                    val ejercicio = res.body()
                    println("Ejercicios: $ejercicio")
                }
            }
            override fun onFailure(call: Call<List<Ejercicios>>, t: Throwable) {
                t.printStackTrace()
            }
        })





        var nombre_ejercicio = findViewById<AutoCompleteTextView>(R.id.nombre_ejercicio).text.toString();
        var grupo_muscular = findViewById<AutoCompleteTextView>(R.id.grupo_ejercicio).text.toString()
        var series_ejercicio = findViewById<AutoCompleteTextView>(R.id.series_ejercicio).text.toString()
        var repeticiones_ejercicio = findViewById<AutoCompleteTextView>(R.id.repeticiones_ejercicio).text.toString()

    }
}
