package com.example.karmacard.core.domain.useCase

import com.example.karmacard.core.domain.model.Group
import com.example.karmacard.core.domain.repository.GroupRepository

class CreateGroupUseCase(
    private val repository: GroupRepository
) {

    suspend operator fun invoke(name: String) {
        val group = Group(name = name)
        repository.createGroup(group)
    }

}