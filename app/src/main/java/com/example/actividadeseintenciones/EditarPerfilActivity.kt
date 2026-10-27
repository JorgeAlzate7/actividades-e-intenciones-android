package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarPerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil)

        val etNombre = findViewById<EditText>(R.id.etNombrePerfil)
        val etCorreo = findViewById<EditText>(R.id.etCorreoPerfil)
        val etEdad = findViewById<EditText>(R.id.etEdadPerfil)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarPerfil)

        // Cargar datos enviados desde MainActivity
        etNombre.setText(intent.getStringExtra("nombre"))
        etCorreo.setText(intent.getStringExtra("correo"))
        etEdad.setText(intent.getIntExtra("edad", 0).toString())

        btnGuardar.setOnClickListener {
            val intentResult = Intent()
            intentResult.putExtra("nombre", etNombre.text.toString())
            intentResult.putExtra("correo", etCorreo.text.toString())
            intentResult.putExtra("edad", etEdad.text.toString().toIntOrNull() ?: 0)

            setResult(Activity.RESULT_OK, intentResult)
            finish()
        }
    }
}