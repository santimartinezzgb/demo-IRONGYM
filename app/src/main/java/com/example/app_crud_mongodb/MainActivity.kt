package com.example.app_crud_mongodb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_iniciar = findViewById<Button>(R.id.btn_iniciar)
        val registrarme = findViewById<Button>(R.id.registrarme)

        btn_iniciar.setOnClickListener {
            val intent = Intent(this, SegundoActivity::class.java)
            startActivity(intent)
        }
        registrarme.setOnClickListener {
            val intent = Intent(this, SegundoActivity::class.java)
            startActivity(intent)
        }

    }
}