package com.example.karmacard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karmacard.domain.useCase.CreateGroupUseCase
import com.example.karmacard.domain.useCase.GetGroupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createGroupUseCase: CreateGroupUseCase,
    private val getGroupsUseCase: GetGroupsUseCase
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