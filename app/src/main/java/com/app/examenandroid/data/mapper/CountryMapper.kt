package com.app.examenandroid.data.mapper

import com.app.examenandroid.data.remote.dto.CountryDto
import com.app.examenandroid.domain.model.Country

// Estandarización del DTO para mandarlo al model
// Transforma ContryDto e implementa en Country
fun CountryDto.toDomain(): Country {
    // Extracción de los nombres nativos
    val nativeNames =
        name.nativeName?.mapNotNull { (_, value) ->
            value.common ?: value.official
        } ?: emptyList()

    return Country(
        // Si algún valor es null se asigna Desconocido
        commonName = name.common ?: "Desconocido",
        officialName = name.official ?: "Desconocido",
        nativeNames = nativeNames,
    )
}
