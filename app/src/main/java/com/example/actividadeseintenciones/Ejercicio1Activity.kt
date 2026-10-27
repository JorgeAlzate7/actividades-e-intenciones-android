package com.example.actividadeseintenciones

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val etTexto = findViewById<EditText>(R.id.etTextoEj1)
        val btnEnviar = findViewById<Button>(R.id.btnEnviarEj1)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoEj1)

        btnEnviar.setOnClickListener {
            val texto = etTexto.text.toString()
            tvResultado.text = "Texto ingresado: $texto"
        }
    }
}