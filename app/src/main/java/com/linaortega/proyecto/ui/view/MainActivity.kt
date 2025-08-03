package com.linaortega.proyecto.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.linaortega.proyecto.R

class MainActivity : AppCompatActivity() {
    private lateinit var btnIrInv: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnIrInv = findViewById(R.id.btnPrueba)

        btnIrInv.setOnClickListener(){
            val intent = Intent(this, InvernaderoActivity::class.java)
            startActivity(intent)
        }

    }
}