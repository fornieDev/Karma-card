package com.example.karmacard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.karmacard.domain.useCase.CreateGroupUseCase
import com.example.karmacard.domain.useCase.GetGroupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.karmacard.core.result.Result

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

    private val _events = MutableSharedFlow<HomeEvent>()
    val events = _events.asSharedFlow()
    fun onAddGroupClicked(name: String) {

        viewModelScope.launch {

            when (val result = createGroupUseCase(name)) {

                is Result.Success -> {
                    _events.emit(HomeEvent.GroupCreated)
                }

                is Result.Error -> {
                    _events.emit(HomeEvent.Error(result.error))
                }
            }
        }

    }

}