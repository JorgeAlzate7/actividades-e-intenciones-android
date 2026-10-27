package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Config12Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config_12)

        val etMensaje = findViewById<EditText>(R.id.etMensaje12)
        val spTamano = findViewById<Spinner>(R.id.spTamanoLetra)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar12)

        val opciones = arrayOf("Pequeño", "Mediano", "Grande")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spTamano.adapter = adapter

        etMensaje.setText(intent.getStringExtra("mensaje"))

        btnGuardar.setOnClickListener {
            val result = Intent()
            result.putExtra("nuevoMensaje", etMensaje.text.toString())
            result.putExtra("tamanoSeleccionado", spTamano.selectedItem.toString())
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}