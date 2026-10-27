package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditarDescripcionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_desc_prod)

        val et = findViewById<EditText>(R.id.etDescProd)
        et.setText(intent.getStringExtra("descripcion"))

        findViewById<Button>(R.id.btnGuardarDescProd).setOnClickListener {
            val res = Intent()
            res.putExtra("nuevaDesc", et.text.toString())
            setResult(Activity.RESULT_OK, res)
            finish()
        }
    }
}