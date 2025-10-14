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

// REGRESO A HACER EXAMEN
// CLASE DE ALGORTIMOS TERMINO 2:30
// FUI A COMER Y REGRESO A HACER EXAMEN A LAS 3:45
