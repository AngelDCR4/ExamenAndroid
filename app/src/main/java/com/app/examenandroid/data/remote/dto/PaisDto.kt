package com.app.examenandroid.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name") val name: NameDto,
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
