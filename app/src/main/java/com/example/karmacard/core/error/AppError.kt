package com.example.karmacard.core.error

sealed class AppError {
    data object Network : AppError()

    data object Database : AppError()

    data object Unauthorized : AppError()

    data object NotFound : AppError()

    data class Unknown(val throwable: Throwable) : AppError()
}