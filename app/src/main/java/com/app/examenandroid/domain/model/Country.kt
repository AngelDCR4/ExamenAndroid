package com.app.examenandroid.domain.model

data class Country(
    val commonName: String,
    val officialName: String,
    val nativeNames: List<String>,
    val independent: Boolean,
    val currencyName: String,
    val currencySymbol: String,
)
