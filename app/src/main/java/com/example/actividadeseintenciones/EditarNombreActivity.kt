package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarNombreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_nombre_prod)

        val et = findViewById<EditText>(R.id.etNombreProd)
        et.setText(intent.getStringExtra("nombre"))

        findViewById<Button>(R.id.btnGuardarNombreProd).setOnClickListener {
            val res = Intent()
            res.putExtra("nuevoNombre", et.text.toString())
            setResult(Activity.RESULT_OK, res)
            finish()
        }
    }
}