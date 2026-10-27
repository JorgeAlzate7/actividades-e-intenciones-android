package com.example.actividadeseintenciones

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        val usuario = intent.getStringExtra("usuario") ?: "Usuario"

        tvBienvenida.text = "Hola, $usuario"
    }
}