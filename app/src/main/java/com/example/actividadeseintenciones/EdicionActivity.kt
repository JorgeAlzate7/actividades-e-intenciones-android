package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EdicionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicion)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        // Cargar datos recibidos desde MainActivity
        val nombreActual = intent.getStringExtra("nombre") ?: ""
        val edadActual = intent.getIntExtra("edad", 0)

        etNombre.setText(nombreActual)
        etEdad.setText(edadActual.toString())

        btnGuardar.setOnClickListener {
            val nuevoNombre = etNombre.text.toString()
            val nuevaEdad = etEdad.text.toString().toIntOrNull() ?: 0

            val intentResultado = Intent()
            intentResultado.putExtra("nuevoNombre", nuevoNombre)
            intentResultado.putExtra("nuevaEdad", nuevaEdad)

            setResult(Activity.RESULT_OK, intentResultado)
            finish()
        }
    }
}