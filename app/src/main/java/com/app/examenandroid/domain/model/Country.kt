package com.app.examenandroid.domain.model

data class Country(
    val commonName: String,
    val officialName: String,
    val isIndependent: Boolean,
    val currencyName: String?,
    val currencySymbol: String?,
    val flagPng: String?,
)
