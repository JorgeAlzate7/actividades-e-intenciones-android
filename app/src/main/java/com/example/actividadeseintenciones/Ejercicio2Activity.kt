package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val etMensajeDevolver = findViewById<EditText>(R.id.etMensajeDevolver)
        val btnDevolver = findViewById<Button>(R.id.btnDevolver)

        btnDevolver.setOnClickListener {
            val mensaje = etMensajeDevolver.text.toString()

            // Preparamos el Intent con los datos que se van a devolver
            val intentResultado = Intent()
            intentResultado.putExtra("respuesta", mensaje)

            // Indicamos que el resultado fue OK y enviamos el Intent
            setResult(Activity.RESULT_OK, intentResultado)
            finish() // Cerramos la actividad
        }
    }
}