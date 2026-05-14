package com.example.karmacard.domain.useCase

import com.example.karmacard.domain.model.Group
import com.example.karmacard.domain.repositoryInt.GroupRepository
import javax.inject.Inject

class CreateGroupUseCase @Inject constructor(
    private val repository: GroupRepository
) {

    suspend operator fun invoke(name: String) {
        val group = Group(name = name)
        repository.createGroup(group)
    }

}