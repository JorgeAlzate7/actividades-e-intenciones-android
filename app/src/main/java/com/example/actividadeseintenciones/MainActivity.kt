package com.example.actividadeseintenciones

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var tvMensajeRecibido: TextView
    private lateinit var tvPerfil: TextView
    private lateinit var tvResultadoEj6: TextView
    private lateinit var tvPerfil7: TextView
    private lateinit var tvContacto8: TextView
    private lateinit var tvMensajeEj9: TextView
    private lateinit var tvLibro10: TextView
    private lateinit var tvNota11: TextView
    private lateinit var tvContador11: TextView
    private lateinit var tvConfigurable12: TextView
    private lateinit var tvProducto13: TextView

    // Estados
    private var nombre7 = "Juan"
    private var correo7 = "juan@mail.com"
    private var edad7 = 20

    private var nombreContacto8 = "Ana López"
    private var telefonoContacto8 = "3001234567"

    private var mensajeEj9 = "Bienvenido a la App"

    private var tituloLibro10 = "Cien Años de Soledad"
    private var autorLibro10 = "Gabriel García Márquez"

    private var textoNota11 = "Comprar materiales para la clase"
    private var contadorEdiciones11 = 0

    private var textoEj12 = "Texto Configurable Ejercicio 12"

    // Valores originales y editables del Ejercicio 13
    private val PROD_NOMBRE_ORIGINAL = "Laptop Gaming"
    private val PROD_PRECIO_ORIGINAL = 1200.0
    private val PROD_DESC_ORIGINAL = "Alta gama para desarrollo"

    private var prodNombre = PROD_NOMBRE_ORIGINAL
    private var prodPrecio = PROD_PRECIO_ORIGINAL
    private var prodDesc = PROD_DESC_ORIGINAL

    // Launchers Ej 1 - 12
    private val launcherEjercicio2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) tvMensajeRecibido.text = "Respuesta Ej2: ${result.data?.getStringExtra("respuesta")}"
    }

    private val launcherEjercicio4 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) tvPerfil.text = "Nombre: ${result.data?.getStringExtra("nuevoNombre")}\nEdad: ${result.data?.getIntExtra("nuevaEdad", 0)} años"
    }

    private val launcherEjercicio6 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) tvResultadoEj6.text = "Resultado Ej6: ${result.data?.getIntExtra("resultadoFinal", 0)}"
    }

    private val launcherEjercicio7 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            nombre7 = result.data?.getStringExtra("nombre") ?: nombre7
            correo7 = result.data?.getStringExtra("correo") ?: correo7
            edad7 = result.data?.getIntExtra("edad", edad7) ?: edad7
            tvPerfil7.text = "Perfil: $nombre7 | $correo7 | $edad7 años"
        }
    }

    private val launcherEjercicio8 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            nombreContacto8 = result.data?.getStringExtra("nuevoNombreContacto") ?: nombreContacto8
            telefonoContacto8 = result.data?.getStringExtra("nuevoTelefonoContacto") ?: telefonoContacto8
            tvContacto8.text = "Contacto: $nombreContacto8 | $telefonoContacto8"
        }
    }

    private val launcherEjercicio9 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            mensajeEj9 = result.data?.getStringExtra("nuevoMensaje") ?: mensajeEj9
            tvMensajeEj9.text = "Mensaje actual: $mensajeEj9"
        }
    }

    private val launcherEditarTitulo = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            tituloLibro10 = result.data?.getStringExtra("nuevoTitulo") ?: tituloLibro10
            tvLibro10.text = "Libro: $tituloLibro10 | $autorLibro10"
        }
    }

    private val launcherEditarAutor = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            autorLibro10 = result.data?.getStringExtra("nuevoAutor") ?: autorLibro10
            tvLibro10.text = "Libro: $tituloLibro10 | $autorLibro10"
        }
    }

    private val launcherEditarNota = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            textoNota11 = result.data?.getStringExtra("nuevaNota") ?: textoNota11
            contadorEdiciones11 = result.data?.getIntExtra("nuevoContador", contadorEdiciones11) ?: contadorEdiciones11
            tvNota11.text = "Nota: $textoNota11"
            tvContador11.text = "Ediciones realizadas: $contadorEdiciones11"
        }
    }

    private val launcherConfig12 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            textoEj12 = result.data?.getStringExtra("nuevoMensaje") ?: textoEj12
            val tamano = result.data?.getStringExtra("tamanoSeleccionado") ?: "Mediano"
            tvConfigurable12.text = textoEj12
            when (tamano) {
                "Pequeño" -> tvConfigurable12.textSize = 12f
                "Mediano" -> tvConfigurable12.textSize = 18f
                "Grande" -> tvConfigurable12.textSize = 26f
            }
        }
    }

    // Launchers Ejercicio 13
    private val launcherEditarProdNombre = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            prodNombre = result.data?.getStringExtra("nuevoNombre") ?: prodNombre
            actualizarVistaProducto()
        }
    }

    private val launcherEditarProdPrecio = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            prodPrecio = result.data?.getDoubleExtra("nuevoPrecio", prodPrecio) ?: prodPrecio
            actualizarVistaProducto()
        }
    }

    private val launcherEditarProdDesc = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            prodDesc = result.data?.getStringExtra("nuevaDesc") ?: prodDesc
            actualizarVistaProducto()
        }
    }

    private fun actualizarVistaProducto() {
        tvProducto13.text = "Producto: $prodNombre | $$prodPrecio | $prodDesc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        tvMensajeRecibido = findViewById(R.id.tvMensajeRecibido)
        tvPerfil = findViewById(R.id.tvPerfil)
        tvResultadoEj6 = findViewById(R.id.tvResultadoEj6)
        tvPerfil7 = findViewById(R.id.tvPerfil7)
        tvContacto8 = findViewById(R.id.tvContacto8)
        tvMensajeEj9 = findViewById(R.id.tvMensajeEj9)
        tvLibro10 = findViewById(R.id.tvLibro10)
        tvNota11 = findViewById(R.id.tvNota11)
        tvContador11 = findViewById(R.id.tvContador11)
        tvConfigurable12 = findViewById(R.id.tvConfigurable12)
        tvProducto13 = findViewById(R.id.tvProducto13)

        findViewById<Button>(R.id.btnEj1).setOnClickListener { startActivity(Intent(this, Ejercicio1Activity::class.java)) }
        findViewById<Button>(R.id.btnEj2).setOnClickListener { launcherEjercicio2.launch(Intent(this, Ejercicio2Activity::class.java)) }
        findViewById<Button>(R.id.btnEj3).setOnClickListener { startActivity(Intent(this, Ejercicio3Activity::class.java).putExtra("objeto_persona", Persona("Carlos", 22))) }
        findViewById<Button>(R.id.btnEj4).setOnClickListener { launcherEjercicio4.launch(Intent(this, EdicionActivity::class.java)) }
        findViewById<Button>(R.id.btnEj5).setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
        findViewById<Button>(R.id.btnEj6).setOnClickListener { launcherEjercicio6.launch(Intent(this, PrimeraActivity::class.java).putExtra("numeroInicial", 10)) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.accion_editar -> { launcherEjercicio7.launch(Intent(this, EditarPerfilActivity::class.java).putExtra("nombre", nombre7).putExtra("correo", correo7).putExtra("edad", edad7)); true }
            R.id.accion_editar_contacto -> { launcherEjercicio8.launch(Intent(this, EditarContactoActivity::class.java).putExtra("nombreContacto", nombreContacto8).putExtra("telefonoContacto", telefonoContacto8)); true }
            R.id.accion_configuracion -> { launcherEjercicio9.launch(Intent(this, ConfigActivity::class.java).putExtra("mensaje", mensajeEj9)); true }
            R.id.accion_editar_titulo -> { launcherEditarTitulo.launch(Intent(this, EditarTituloActivity::class.java).putExtra("titulo", tituloLibro10)); true }
            R.id.accion_editar_autor -> { launcherEditarAutor.launch(Intent(this, EditarAutorActivity::class.java).putExtra("autor", autorLibro10)); true }
            R.id.accion_editar_nota -> { launcherEditarNota.launch(Intent(this, EditarNotaActivity::class.java).putExtra("nota", textoNota11).putExtra("contador", contadorEdiciones11)); true }
            R.id.accion_config12 -> { launcherConfig12.launch(Intent(this, Config12Activity::class.java).putExtra("mensaje", textoEj12)); true }

            // Opciones Ejercicio 13
            R.id.accion_editar_prod_nombre -> { launcherEditarProdNombre.launch(Intent(this, EditarNombreActivity::class.java).putExtra("nombre", prodNombre)); true }
            R.id.accion_editar_prod_precio -> { launcherEditarProdPrecio.launch(Intent(this, EditarPrecioActivity::class.java).putExtra("precio", prodPrecio)); true }
            R.id.accion_editar_prod_desc -> { launcherEditarProdDesc.launch(Intent(this, EditarDescripcionActivity::class.java).putExtra("descripcion", prodDesc)); true }
            R.id.accion_restablecer_prod -> {
                prodNombre = PROD_NOMBRE_ORIGINAL
                prodPrecio = PROD_PRECIO_ORIGINAL
                prodDesc = PROD_DESC_ORIGINAL
                actualizarVistaProducto()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}