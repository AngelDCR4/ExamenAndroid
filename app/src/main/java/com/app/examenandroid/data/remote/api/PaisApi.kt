package com.app.examenandroid.data.remote.api

import com.app.examenandroid.data.remote.dto.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interfaz que define el endpoint de la API.
 *
 * Devuelve una lista completa de países
 * y los datos para consultar los detalles de un país en específico.
 */
interface PaisApi {
    // Endpoint que devuelve una lista de países
    @GET("v3.1/all?fields=name")
    suspend fun getPaises(): List<CountryDto>

    // Detalle de un país por nombre
    @GET("v3.1/name/{countryName}")
    suspend fun getPaisByName(
        @Path("countryName") name: String,
    ): List<CountryDto>
}
