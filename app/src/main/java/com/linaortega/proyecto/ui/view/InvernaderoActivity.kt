package com.linaortega.proyecto.ui.view

import android.content.Intent
import android.os.Bundle //es donde vienen los datos al iniciar la pantalla.
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.linaortega.proyecto.R
import com.linaortega.proyecto.adapter.InvernaderoAdapter
import com.linaortega.proyecto.model.Invernadero
import com.linaortega.proyecto.model.Zona
import com.linaortega.proyecto.network.ApiClient
import com.linaortega.proyecto.network.ApiInvernadero


import kotlinx.coroutines.launch

class InvernaderoActivity : AppCompatActivity() {

    private lateinit var listView: ListView //Declara una variable listView que luego se va a conectar con el xml
    //lateinit te permite no inicializarla en ese momento, sino en onCreate.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invernadero)

        listView = findViewById(R.id.lvInvernaderos)


        // Llamar a la API
        lifecycleScope.launch { // para implemnetra una corutina
            try {
                val response = ApiClient.getClient().create(ApiInvernadero::class.java).getInvernaderos()
                if (response.isSuccessful && response.body() != null) {
                    val invernaderos: List<Invernadero> = response.body()!!
                    val adapter = InvernaderoAdapter(this@InvernaderoActivity, invernaderos)
                    listView.adapter = adapter
                } else {
                    Toast.makeText(this@InvernaderoActivity, "Error al obtener datos", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@InvernaderoActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

    }
}