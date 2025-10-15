package com.app.examenandroid.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.examenandroid.data.local.DataStoreManager
import com.app.examenandroid.domain.usecase.GetCountryByNameUseCase
import com.app.examenandroid.presentation.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel encargado de manejar los datos del detalle de un país
 *
 * Recupera la información del país seleccionado desde la capa de domain
 * y la lleva a la View
 * Guarda el último país visitado en las preferencias del usuario
 */
@HiltViewModel
class CountryDetailViewModel
    @Inject
    constructor(
        private val getCountryByNameUseCase: GetCountryByNameUseCase,
        private val dataStoreManager: DataStoreManager,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(CountryDetailUiState())
        val uiState: StateFlow<CountryDetailUiState> = _uiState.asStateFlow()

        fun loadCountry(name: String) {
            viewModelScope.launch {
                getCountryByNameUseCase(name).collect { result ->
                    _uiState.update { state ->
                        when (result) {
                            is Result.Loading -> state.copy(isLoading = true)

                            is Result.Success -> {
                                val country = result.data
                                if (country != null) {
                                    viewModelScope.launch {
                                        dataStoreManager.saveLastCountry(country.commonName)
                                    }
                                }
                                state.copy(
                                    country = country,
                                    isLoading = false,
                                    error = null,
                                )
                            }

                            is Result.Error ->
                                state.copy(
                                    error = result.exception.message,
                                    isLoading = false,
                                )
                        }
                    }
                }
            }
        }
    }
