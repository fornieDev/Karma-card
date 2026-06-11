package com.example.karmacard.domain.repositoryInt

import com.example.karmacard.domain.model.Group
import kotlinx.coroutines.flow.Flow
import com.example.karmacard.core.result.Result

interface GroupRepository {

    suspend fun createGroup(group: Group) : Result<Unit>

    fun getGroups(): Flow<List<Group>>

    suspend fun syncPendingGroups(): Result<Unit>
}