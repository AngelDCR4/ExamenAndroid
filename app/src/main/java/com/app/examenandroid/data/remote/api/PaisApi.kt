package com.app.examenandroid.data.remote.api

import com.app.examenandroid.data.remote.dto.CountryDto
import retrofit2.http.GET

interface PaisApi {
    // Endpoint que devuelve todos los paises
    @GET("v3.1/all?fields=name")
    suspend fun getPaises(): List<CountryDto>
}
