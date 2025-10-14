package com.app.examenandroid.domain.model

data class Country(
    // Nombre comun
    val commonName: String,
    // Nombre oficial
    val officialName: String,
    // Nombres nativos
    val nativeNames: List<String>,
)
