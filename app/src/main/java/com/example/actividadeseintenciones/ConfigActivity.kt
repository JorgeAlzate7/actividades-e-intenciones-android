package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        val etNuevoMensaje = findViewById<EditText>(R.id.etNuevoMensaje)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarMensaje)

        etNuevoMensaje.setText(intent.getStringExtra("mensaje"))

        btnGuardar.setOnClickListener {
            val intentResult = Intent()
            intentResult.putExtra("nuevoMensaje", etNuevoMensaje.text.toString())
            setResult(Activity.RESULT_OK, intentResult)
            finish()
        }
    }
}