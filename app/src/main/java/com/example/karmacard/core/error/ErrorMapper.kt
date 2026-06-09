package com.example.karmacard.core.error

import java.io.IOException

fun Throwable.toAppError(): AppError {
    return when (this) {
        is IOException -> AppError.Network
        else -> AppError.Unknown(this)
    }
}