package com.app.examenandroid.presentation.screens.home

import com.app.examenandroid.domain.model.Country

data class HomeUiState(
    val countries: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
