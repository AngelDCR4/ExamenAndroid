package com.app.examenandroid.data.mapper

import com.app.examenandroid.data.remote.dto.CountryDto
import com.app.examenandroid.domain.model.Country

fun CountryDto.toDomain(): Country {
    val nativeNames =
        name.nativeName?.mapNotNull { (_, value) ->
            value.common ?: value.official
        } ?: emptyList()

    val firstCurrency = currencies?.values?.firstOrNull()
    val currencyName = firstCurrency?.name ?: "Unknown"
    val currencySymbol = firstCurrency?.symbol ?: "?"

    return Country(
        commonName = name.common ?: "Unknown",
        officialName = name.official ?: "Unknown",
        nativeNames = nativeNames,
        independent = independent ?: false,
        currencyName = currencyName,
        currencySymbol = currencySymbol,
    )
}
