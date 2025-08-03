package com.linaortega.proyecto.network

import com.linaortega.proyecto.model.Zona
import retrofit2.Response  //Esta clase representa la respuesta HTTP completa
import retrofit2.http.*

interface ApiZona {
    @GET("api/zona") //este método realizará una petición GET desde ese endpoitn
    suspend fun getZonas(): Response<List<Zona>>
    //(suspend) Indica que la función se puede ejecutar de forma asíncrona
}