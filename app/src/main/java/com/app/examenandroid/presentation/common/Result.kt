package com.app.examenandroid.presentation.common

// Representar los estados de la UI (Loading, Success, Error)
sealed class Result<out T> {
    object Loading : Result<Nothing>() // No contiene datos

    data class Success<T>(
        val data: T,
    ) : Result<T>() // Contiene los datos de éxito

    data class Error(
        val exception: Throwable,
    ) : Result<Nothing>() // Contiene el error
}

// TIEMPOOOOOOOOOOOOOOOOOO SE ACABO LA CLASE
// ME TOCA MATERIA DE ALGORITMOS
