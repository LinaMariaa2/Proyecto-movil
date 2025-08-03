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
    private val context: Context,
    private val data: List<Invernadero>
) : BaseAdapter() {

    override fun getCount(): Int = data.size
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

        nombre.text = invernadero.nombre
        descripcion.text = invernadero.descripcion
        estado.text = "Estado: ${invernadero.estado}"
        zonasTotales.text = "Zonas Totales: ${invernadero.zonas_totales}"
        zonasActivas.text = "Zonas Activas: ${invernadero.zonas_activas}"

        btnInvZonas.setOnClickListener {
            val intent = Intent(context, ZonaActivity::class.java).apply {
                putExtra("id_invernadero", invernadero.id_invernadero)
            }
            context.startActivity(intent)
        }

        return view
    }
}
