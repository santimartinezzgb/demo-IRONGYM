package com.example.app_crud_mongodb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        // Botón para volver al menú principal
        val volver = findViewById<Button>(R.id.volver)
        volver.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        // Botón para añadir un ejercicio
        val btnAnadirEjercicio = findViewById<Button>(R.id.btnAddEjercicio)
        btnAnadirEjercicio.setOnClickListener {
            val intent = Intent(this, AnadirEjercicio::class.java)
            startActivity(intent)
        }


        // Botón para listar ejercicios
        val btnListarEjercicios = findViewById<Button>(R.id.btnListarEjercicios)
        btnListarEjercicios.setOnClickListener {
            val intent = Intent(this, ListarEjercicio::class.java)
            startActivity(intent)
        }

    }
}