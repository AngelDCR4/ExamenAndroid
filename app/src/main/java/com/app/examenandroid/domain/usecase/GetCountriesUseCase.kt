package com.app.examenandroid.domain.usecase

import com.app.examenandroid.domain.model.Country
import com.app.examenandroid.domain.repository.CountryRepository
import com.app.examenandroid.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Caso de uso que define la obtenencion de todos los paises
 *
 * Interactúa con repository del domain para recuperar los datos
 * y los expone como un flujo reactivo de tipo Result
 * para manejar los estados de carga, éxito y error.
 */
class GetCountriesUseCase
    @Inject
    constructor(
        private val repository: CountryRepository,
    ) {
        operator fun invoke(): Flow<Result<List<Country>>> =
            flow {
                try {
                    emit(Result.Loading)
                    val countries = repository.getCountries()
                    emit(Result.Success(countries))
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
    }
