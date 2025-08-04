package com.linaortega.proyecto.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.linaortega.proyecto.R
import com.linaortega.proyecto.model.Invernadero
import com.linaortega.proyecto.ui.view.ZonaActivity

class InvernaderoAdapter(
    private val context: Context, // constructor
    private val data: List<Invernadero> // trae la lista de invernaderos
) : BaseAdapter() {

    override fun getCount(): Int = data.size // Devuelve cuántos elementos hay en la lista
    override fun getItem(position: Int): Any = data[position]
    override fun getItemId(position: Int): Long = data[position].id_invernadero.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.items_invernadero, parent, false)

        val nombre = view.findViewById<TextView>(R.id.tvNombreInv)
        val descripcion = view.findViewById<TextView>(R.id.tvDescripcionesInv)
        val estado = view.findViewById<TextView>(R.id.tvEstadpInv)
        val zonasTotales = view.findViewById<TextView>(R.id.tvZonasTotalesInv)
        val zonasActivas = view.findViewById<TextView>(R.id.tvZonasActivas)
        val btnInvZonas = view.findViewById<Button>(R.id.btnInvZonas)
        val invernadero = data[position]

        //Asigna las propiedades al listview
        nombre.text = invernadero.nombre
        descripcion.text = invernadero.descripcion
        estado.text = "Estado: ${invernadero.estado}"
        zonasTotales.text = "Zonas Totales: ${invernadero.zonas_totales}"
        zonasActivas.text = "Zonas Activas: ${invernadero.zonas_activas}"

        //Evento click para ir a la gestion de las zonas
        btnInvZonas.setOnClickListener {
            val intent = Intent(context, ZonaActivity::class.java).apply { //(aply) permite ejecutar acciones sobre el objeto recién creado
                putExtra("id_invernadero", invernadero.id_invernadero)
                // añade un dato adicional al intent, el id del invernadero lo que nos servira mas adelante
            }
            context.startActivity(intent)
        }
        //cuando trabaamos con un adpter significa que estamos trabajando sobre una clase externa y por eso
        // no tendra todos los metodos que una normal y no podria saber desde donde estamos navegando mejordicho no accederia este metodo
        return view
    }
}
