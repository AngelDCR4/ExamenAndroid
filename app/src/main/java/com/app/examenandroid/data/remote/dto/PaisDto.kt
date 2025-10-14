package com.app.examenandroid.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name") val name: NameDto,
    @SerializedName("independent") val independent: Boolean?,
    @SerializedName("currencies") val currencies: Map<String, CurrencyDto>?,
    @SerializedName("flags") val flags: FlagsDto?,
)

data class NameDto(
    @SerializedName("common") val common: String?,
    @SerializedName("official") val official: String?,
    @SerializedName("nativeName") val nativeName: Map<String, NativeNameDto>?,
)

data class NativeNameDto(
    @SerializedName("official") val official: String?,
    @SerializedName("common") val common: String?,
)

data class CurrencyDto(
    @SerializedName("symbol") val symbol: String?,
    @SerializedName("name") val name: String?,
)

data class FlagsDto(
    @SerializedName("png") val png: String?,
    @SerializedName("svg") val svg: String?,
)
