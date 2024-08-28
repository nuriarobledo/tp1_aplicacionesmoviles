package com.example.tp1_aplicacionesmoviles

import android.content.Intent //permite navegar entre pantallas
import android.os.Bundle //Contiene los datos de la instancia anterior de la actividad si es que se está recreando.
import android.util.Log //Se utiliza para escribir mensajes de depuración.
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge //Método para habilitar el diseño de borde a borde.
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat //Herramientas de compatibilidad para manejar las ventanas e insets en Android.
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {

    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        btnIniciarSesion.setOnClickListener{

            val etUsuario = findViewById<EditText>(R.id.etUsuario).text.toString()

            val etContrasena = findViewById<EditText>(R.id.etContrasena).text.toString()

            // logs

            Log.d(tag, "Usuario ingresado: $etUsuario")
            Log.d(tag, "Contraseña ingresada: $etContrasena")

            if (etUsuario == "Juan Torres" && etContrasena == "1234utn"){
                Log.i(tag, "Inicio de sesión exitoso")
                val intent = Intent(this, Home::class.java).apply {
                    putExtra("USERNAME", etUsuario)
                }
                startActivity(intent)
                Toast.makeText(this, "¡Bienvenido, $etUsuario!", Toast.LENGTH_SHORT).show()
            } else {
                Log.e(tag, "Credenciales incorrectas")

                Toast.makeText(this, "El usuario o la contraseña son incorrectos.", Toast.LENGTH_SHORT).show()
            }
        }

        val btnRegistrate = findViewById<Button>(R.id.btnRegistrate)
        btnRegistrate.setOnClickListener{
            Log.d(tag, "Botón de registro presionado")

            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}