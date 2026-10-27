package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarNotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_nota)

        val etNota = findViewById<EditText>(R.id.etTextoNota)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarNota)

        val contadorActual = intent.getIntExtra("contador", 0)
        etNota.setText(intent.getStringExtra("nota"))

        btnGuardar.setOnClickListener {
            val result = Intent()
            result.putExtra("nuevaNota", etNota.text.toString())
            result.putExtra("nuevoContador", contadorActual + 1)
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}