package com.example.actividadeseintenciones

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PrimeraActivity : AppCompatActivity() {

    // Recibe el resultado de Ejercicio6SegundaActivity y se lo reenvía a MainActivity
    private val launcherSegunda = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            setResult(Activity.RESULT_OK, result.data)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio6_primera)

        val numeroInicial = intent.getIntExtra("numeroInicial", 0)
        val tvNumeroInicial = findViewById<TextView>(R.id.tvNumeroInicial)
        val etSumar = findViewById<EditText>(R.id.etSumar)
        val btnPasar = findViewById<Button>(R.id.btnPasarASegunda)

        tvNumeroInicial.text = "Número inicial enviado: $numeroInicial"

        btnPasar.setOnClickListener {
            val valorASumar = etSumar.text.toString().toIntOrNull() ?: 0
            val sumaTotal = numeroInicial + valorASumar

            val intent = Intent(this, Ejercicio6SegundaActivity::class.java)
            intent.putExtra("suma", sumaTotal)
            launcherSegunda.launch(intent)
        }
    }
}