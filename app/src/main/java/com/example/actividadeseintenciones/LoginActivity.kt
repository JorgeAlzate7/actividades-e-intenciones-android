package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etClave = findViewById<EditText>(R.id.etClave)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val clave = etClave.text.toString()

            // Validación simple (usuario: admin, clave: 1234)
            if (usuario == "admin" && clave == "1234") {
                val intent = Intent(this, BienvenidaActivity::class.java)
                intent.putExtra("usuario", usuario)
                startActivity(intent)
            } else {
                // Si no es válido, devuelve RESULT_CANCELED y muestra un Toast
                Toast.makeText(this, "Datos incorrectos. Acceso denegado.", Toast.LENGTH_SHORT).show()
                setResult(Activity.RESULT_CANCELED)
            }
        }
    }
}