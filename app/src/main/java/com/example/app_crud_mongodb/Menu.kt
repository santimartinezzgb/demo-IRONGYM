package com.example.app_crud_mongodb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu  : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun salirApp() {
            finishAffinity()
        }

        val acceder = findViewById<Button>(R.id.acceder)
        val zona_cliente = findViewById<Button>(R.id.zona_cliente)
        val salir = findViewById<Button>(R.id.salir)

        acceder.setOnClickListener {
            val intent = Intent(this, QR::class.java)
            startActivity(intent)
        }
        zona_cliente.setOnClickListener {
            val intent = Intent(this, ZonaCliente::class.java)
            startActivity(intent)
        }
        salir.setOnClickListener {
            salirApp()
        }
    }
}