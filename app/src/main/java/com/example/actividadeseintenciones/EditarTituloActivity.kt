package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarTituloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_titulo)

        val etTitulo = findViewById<EditText>(R.id.etTituloLibro)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarTitulo)

        etTitulo.setText(intent.getStringExtra("titulo"))

        btnGuardar.setOnClickListener {
            val result = Intent()
            result.putExtra("nuevoTitulo", etTitulo.text.toString())
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}