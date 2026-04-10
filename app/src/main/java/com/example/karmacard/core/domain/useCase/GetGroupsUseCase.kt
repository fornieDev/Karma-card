package com.example.karmacard.core.domain.useCase

import com.example.karmacard.core.domain.model.Group
import com.example.karmacard.core.domain.repository.GroupRepository
import kotlinx.coroutines.flow.Flow

class GetGroupsUseCase (
    private val repository: GroupRepository
){
    operator fun invoke(): Flow<List<Group>> {
        return repository.getGroups()
    }
}