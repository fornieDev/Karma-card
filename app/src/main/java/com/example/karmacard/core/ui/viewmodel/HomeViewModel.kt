package com.example.karmacard.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karmacard.core.domain.useCase.CreateGroupUseCase
import com.example.karmacard.core.domain.useCase.GetGroupsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val createGroupUseCase: CreateGroupUseCase,
    getGroupsUseCase: GetGroupsUseCase
) : ViewModel() {

    val groups = getGroupsUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onAddGroupClicked(name: String) {

        viewModelScope.launch {
            createGroupUseCase(name)
        }

    }

}