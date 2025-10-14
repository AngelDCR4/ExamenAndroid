package com.app.examenandroid.presentation.screens.detail

import com.app.examenandroid.domain.model.Country

data class CountryDetailUiState(
    val country: Country? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
