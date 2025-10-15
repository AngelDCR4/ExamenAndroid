package com.app.examenandroid.data.repository

import com.app.examenandroid.data.mapper.toDomain
import com.app.examenandroid.data.remote.api.PaisApi
import com.app.examenandroid.domain.model.Country
import com.app.examenandroid.domain.repository.CountryRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementación del repositorio del domain
 *
 * Se encarga de obtener los datos desde la API remota,
 * mapear los modelos de dominio y manejar errores.
 *
 */
@Singleton
class CountryRepositoryImpl
    @Inject
    constructor(
        private val api: PaisApi,
    ) : CountryRepository {
        /**
         * Obtiene la lista de los paises
         **/
        override suspend fun getCountries(): List<Country> {
            val response = api.getPaises()
            return response.map { it.toDomain() }
        }

        /**
         * Obtiene la informacion de un pais por nombre
         **/
        override suspend fun getCountryByName(name: String): Country? =
            try {
                val response = api.getPaisByName(name)
                response.firstOrNull()?.toDomain()
            } catch (e: Exception) {
                null
            }
    }
