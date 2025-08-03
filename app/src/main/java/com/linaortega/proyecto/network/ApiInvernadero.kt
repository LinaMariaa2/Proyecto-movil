package com.linaortega.proyecto.network

import com.linaortega.proyecto.model.Invernadero
import retrofit2.Response
import retrofit2.http.*

interface ApiInvernadero {

    @GET("api/invernadero")
    suspend fun getInvernaderos(): Response<List<Invernadero>>

}
