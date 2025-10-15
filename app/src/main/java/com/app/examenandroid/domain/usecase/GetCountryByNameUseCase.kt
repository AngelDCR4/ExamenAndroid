package com.app.examenandroid.domain.usecase

import com.app.examenandroid.domain.model.Country
import com.app.examenandroid.domain.repository.CountryRepository
import com.app.examenandroid.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Caso de uso que define la obtenencion de un pais por nombre
 *
 * Interactua con repository de Domain para recuperar los datos
 * y los expone como un flujo reactivo de tipo Result
 * para manejar los estados de carga, éxito y error.
 */
class GetCountryByNameUseCase
    @Inject
    constructor(
        private val repository: CountryRepository,
    ) {
        operator fun invoke(name: String): Flow<Result<Country?>> =
            flow {
                try {
                    emit(Result.Loading)
                    val country = repository.getCountryByName(name)
                    emit(Result.Success(country))
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
    }
