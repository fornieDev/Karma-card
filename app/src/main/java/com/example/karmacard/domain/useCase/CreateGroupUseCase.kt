package com.example.karmacard.domain.useCase

import com.example.karmacard.domain.model.Group
import com.example.karmacard.domain.repositoryInt.GroupRepository
import javax.inject.Inject
import com.example.karmacard.core.result.Result

class CreateGroupUseCase @Inject constructor(
    private val repository: GroupRepository
) {

    suspend operator fun invoke(name: String) : Result <Unit> {
        return repository.createGroup(Group(name = name))
    }

}