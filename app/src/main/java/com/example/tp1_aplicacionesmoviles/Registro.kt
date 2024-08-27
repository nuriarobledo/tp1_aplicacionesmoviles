package com.example.tp1_aplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        // Configuración de insets para ajustes de pantalla
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //logica y manejo de botones
        val btnRegistrarme = findViewById<Button>(R.id.btnRegistrarme)

        btnRegistrarme.setOnClickListener {
            val etNombre = findViewById<EditText>(R.id.etNombre).text.toString()
            val etEmail = findViewById<EditText>(R.id.etEmailAddress).text.toString()
            val etContrasena = findViewById<EditText>(R.id.etTextPassword).text.toString()
            val etContrasena2 = findViewById<EditText>(R.id.etTextPassword2).text.toString()

            var valid = true

            // campos vacios
            if (etNombre.isEmpty()){
                Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show()
                valid = false
            }

            if (etEmail.isEmpty()){
                Toast.makeText(this, "Debe ingresar un email", Toast.LENGTH_SHORT).show()
                valid = false
            }

            if (etContrasena.length < 6){
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                valid = false
            }

            if (etContrasena != etContrasena2) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                valid = false
            }

            if (valid) {
                Toast.makeText(this, "Se registró correctamente", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}