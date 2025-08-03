package com.linaortega.proyecto.model
import com.linaortega.proyecto.model.Estado

data class Zona(
    val id_zona: Int,
    val nombre: String,
    val descripciones_add: String,
    val estado: Estado,
    val id_invernadero: Invernadero
)
