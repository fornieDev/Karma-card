package com.example.karmacard.ui.viewmodel

import com.example.karmacard.core.error.AppError

sealed class HomeEvent {
    data object GroupCreated : HomeEvent()

    data class Error(val error: AppError) : HomeEvent()
}