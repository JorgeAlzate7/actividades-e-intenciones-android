package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_contacto)

        val etNombre = findViewById<EditText>(R.id.etNombreContacto)
        val etTelefono = findViewById<EditText>(R.id.etTelefonoContacto)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarContacto)

        // Cargar datos actuales enviados
        etNombre.setText(intent.getStringExtra("nombreContacto"))
        etTelefono.setText(intent.getStringExtra("telefonoContacto"))

        btnGuardar.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("nuevoNombreContacto", etNombre.text.toString())
            resultIntent.putExtra("nuevoTelefonoContacto", etTelefono.text.toString())

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}