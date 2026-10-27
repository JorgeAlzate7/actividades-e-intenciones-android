package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio6SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio6_segunda)

        val sumaAcumulada = intent.getIntExtra("suma", 0)
        val tvSumaAcumulada = findViewById<TextView>(R.id.tvSumaAcumulada)
        val etMultiplicar = findViewById<EditText>(R.id.etMultiplicar)
        val btnFinalizar = findViewById<Button>(R.id.btnFinalizar)

        tvSumaAcumulada.text = "Suma acumulada: $sumaAcumulada"

        btnFinalizar.setOnClickListener {
            val factor = etMultiplicar.text.toString().toIntOrNull() ?: 1
            val resultadoFinal = sumaAcumulada * factor

            val intentResultado = Intent()
            intentResultado.putExtra("resultadoFinal", resultadoFinal)
            setResult(Activity.RESULT_OK, intentResultado)
            finish()
        }
    }
}