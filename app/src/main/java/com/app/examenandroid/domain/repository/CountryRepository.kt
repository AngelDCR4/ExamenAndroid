package com.app.examenandroid.domain.repository

import com.app.examenandroid.domain.model.Country

// Definimos el QUE es lo que hace la app como:
// Obtener la lista de los paises que venga de la API

interface CountryRepository {
    // Funcion que  devuelve una lista de paises
    suspend fun getCountries(): List<Country>
}
