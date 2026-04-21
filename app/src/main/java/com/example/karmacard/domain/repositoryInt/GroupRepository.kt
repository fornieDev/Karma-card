package com.example.karmacard.domain.repositoryInt

import com.example.karmacard.domain.model.Group
import kotlinx.coroutines.flow.Flow

interface GroupRepository {

    suspend fun createGroup(group: Group)

    //de momento solo escritura
    //suspend fun getGroups(): List<Group>
    fun getGroups(): Flow<List<Group>>
}