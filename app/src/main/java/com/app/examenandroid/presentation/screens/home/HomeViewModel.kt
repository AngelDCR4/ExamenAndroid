package com.app.examenandroid.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.examenandroid.data.local.DataStoreManager
import com.app.examenandroid.domain.usecase.GetCountriesUseCase
import com.app.examenandroid.presentation.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel de la pantalla Home
 *
 * Maneja la logica de presentación para cargar la lista de países,
 * aplicar el filtro de búsqueda, presentar el boton de acerca de la app
 * y recuperar el último país visitado guardado
 * mediante DataStore.
 *
 */
@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getCountriesUseCase: GetCountriesUseCase,
        private val dataStoreManager: DataStoreManager,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(HomeUiState())
        val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

        var lastCountryVisited: String? = null
            private set

        init {
            viewModelScope.launch {
                // Leer país guardado antes de cargar los datos
                lastCountryVisited = dataStoreManager.lastCountry.first()
                loadCountries()
            }
        }

        private fun loadCountries() {
            viewModelScope.launch {
                getCountriesUseCase().collect { result ->
                    _uiState.update { state ->
                        when (result) {
                            is Result.Loading -> state.copy(isLoading = true)
                            is Result.Success ->
                                state.copy(
                                    countries = result.data,
                                    filteredCountries = result.data,
                                    isLoading = false,
                                    error = null,
                                )
                            is Result.Error ->
                                state.copy(
                                    isLoading = false,
                                    error = result.exception.message,
                                )
                        }
                    }
                }
            }
        }

        fun onSearchQueryChanged(query: String) {
            _uiState.update { state ->
                val filtered =
                    if (query.isBlank()) {
                        state.countries
                    } else {
                        state.countries.filter {
                            it.commonName.contains(query, ignoreCase = true)
                        }
                    }
                state.copy(
                    searchQuery = query,
                    filteredCountries = filtered,
                )
            }
        }
    }
