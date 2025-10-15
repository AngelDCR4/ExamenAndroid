package com.app.examenandroid.domain.repository

import com.app.examenandroid.domain.model.Country

/**
 * Definimos las reglas de negocio de nuestra app
 * Obtener la lista de los paises que venga de la API
 * Obtener la información de un pais por nombre
 */
interface CountryRepository {
    // Funcion que  devuelve una lista de paises
    suspend fun getCountries(): List<Country>

    suspend fun getCountryByName(name: String): Country?
}
