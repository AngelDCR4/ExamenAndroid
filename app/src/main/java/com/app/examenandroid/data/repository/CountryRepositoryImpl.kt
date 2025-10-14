package com.app.examenandroid.data.repository

import com.app.examenandroid.data.mapper.toDomain
import com.app.examenandroid.data.remote.api.PaisApi
import com.app.examenandroid.domain.model.Country
import com.app.examenandroid.domain.repository.CountryRepository
import javax.inject.Inject
import javax.inject.Singleton

// Se encarga de obtener los datos de la API
@Singleton
class CountryRepositoryImpl
    @Inject
    constructor(
        private val api: PaisApi,
    ) : CountryRepository {
        override suspend fun getCountries(): List<Country> {
            val response = api.getPaises()
            return response.map { it.toDomain() }
        }

        override suspend fun getCountryByName(name: String): Country? =
            try {
                val response = api.getPaisByName(name)
                response.firstOrNull()?.toDomain()
            } catch (e: Exception) {
                null
            }
    }
