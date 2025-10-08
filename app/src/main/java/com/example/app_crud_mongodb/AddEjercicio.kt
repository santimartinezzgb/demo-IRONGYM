package com.example.app_crud_mongodb

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private fun AutoCompleteTextView.setAdapter(adapter: ArrayAdapter<String>) {}

class AddEjercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_5_addejercicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addejercicio)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val zona_muscular = listOf("Pectoral", "Espalda", "Cuádriceps", "Femoral", "Glúteo","Tríceps","Bíceps")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, zona_muscular)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        autoCompleteTextView.setAdapter(adapter)
    }
}