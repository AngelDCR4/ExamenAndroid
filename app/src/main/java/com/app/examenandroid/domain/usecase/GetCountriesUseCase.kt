package com.app.examenandroid.domain.usecase

import com.app.examenandroid.domain.model.Country
import com.app.examenandroid.domain.repository.CountryRepository
import com.app.examenandroid.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

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
