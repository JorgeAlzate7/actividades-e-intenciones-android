package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarAutorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_autor)

        val etAutor = findViewById<EditText>(R.id.etAutorLibro)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarAutor)

        etAutor.setText(intent.getStringExtra("autor"))

        btnGuardar.setOnClickListener {
            val result = Intent()
            result.putExtra("nuevoAutor", etAutor.text.toString())
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}