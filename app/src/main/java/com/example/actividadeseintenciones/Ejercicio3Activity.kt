package com.example.actividadeseintenciones

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        val tvDatos = findViewById<TextView>(R.id.tvDatosPersona)

        // Recibimos el objeto enviado desde MainActivity
        val persona = intent.getSerializableExtra("objeto_persona") as? Persona

        if (persona != null) {
            tvDatos.text = "Nombre: ${persona.nombre}\nEdad: ${persona.edad} años"
        } else {
            tvDatos.text = "No se recibieron datos"
        }
    }
}