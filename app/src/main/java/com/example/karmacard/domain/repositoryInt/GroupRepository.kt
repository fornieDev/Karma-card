package com.example.karmacard.domain.repositoryInt

import com.example.karmacard.domain.model.Group
import kotlinx.coroutines.flow.Flow
import com.example.karmacard.core.result.Result

interface GroupRepository {

    suspend fun createGroup(group: Group) : Result<Unit>

    //de momento solo escritura
    //suspend fun getGroups(): List<Group>
    fun getGroups(): Flow<List<Group>>
}