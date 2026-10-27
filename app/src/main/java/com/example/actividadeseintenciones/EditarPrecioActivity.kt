package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarPrecioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_precio_prod)

        val et = findViewById<EditText>(R.id.etPrecioProd)
        et.setText(intent.getDoubleExtra("precio", 0.0).toString())

        findViewById<Button>(R.id.btnGuardarPrecioProd).setOnClickListener {
            val res = Intent()
            res.putExtra("nuevoPrecio", et.text.toString().toDoubleOrNull() ?: 0.0)
            setResult(Activity.RESULT_OK, res)
            finish()
        }
    }
}