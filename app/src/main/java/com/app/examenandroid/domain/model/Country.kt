package com.app.examenandroid.domain.model

/**
 * Recibe el nombre nativo,
 * el nombre oficial,
 * si es independiente,
 * el nombre de la moneda,
 * el simbolo de la moneda
 * */
data class Country(
    val commonName: String,
    val officialName: String,
    val isIndependent: Boolean,
    val currencyName: String?,
    val currencySymbol: String?,
    val flagPng: String?,
)
