package com.example.tp1_aplicacionesmoviles

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.CheckBox
import android.widget.EditText
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        //config edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //componentes UI
        val rgSO = findViewById<RadioGroup>(R.id.rgSO)
        val ivLogo = findViewById<ImageView>(R.id.ivLogo)
        val cbOtra = findViewById<CheckBox>(R.id.cbOtra)
        val etPreferencia = findViewById<EditText>(R.id.etPreferencia)

        //segun la seleccion
        rgSO.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbAndroid -> {
                    // mostrar logo de Android
                    ivLogo.setImageResource(R.drawable.logo_android)
                }
                R.id.rbIos -> {
                    // mostrar logo de iOS
                    ivLogo.setImageResource(R.drawable.logo_ios)
                }
            }
        }

        //mostrar u ocultar el campo "otra"
        cbOtra.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                etPreferencia.visibility = View.VISIBLE
            } else {
                etPreferencia.visibility = View.GONE
            }
        }
    }
}