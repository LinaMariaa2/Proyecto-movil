package com.linaortega.proyecto.model
import com.linaortega.proyecto.model.Estado

//Porpiedades del modelo inv
//data class es una clase especial diseñada para contener datos.
data class Invernadero(
    val id_invernadero: Int,
    val nombre: String,
    val descripcion: String,
    val zonas_totales: Int,
    val zonas_activas: Int,
    val estado: Estado
    //val  responsable_id: Responsable_id
)
//val para que sean inmutables var si queremos cmabiarlos despues
