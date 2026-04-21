package com.example.karmacard.domain.useCase

import com.example.karmacard.domain.model.Group
import com.example.karmacard.domain.repositoryInt.GroupRepository
import kotlinx.coroutines.flow.Flow

class GetGroupsUseCase (
    private val repository: GroupRepository
){
    operator fun invoke(): Flow<List<Group>> {
        return repository.getGroups()
    }
}