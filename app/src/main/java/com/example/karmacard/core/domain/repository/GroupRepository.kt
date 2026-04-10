package com.example.karmacard.core.domain.repository

import com.example.karmacard.core.domain.model.Group
import kotlinx.coroutines.flow.Flow

interface GroupRepository {

    suspend fun createGroup(group: Group)

    //de momento solo escritura
    //suspend fun getGroups(): List<Group>
    fun getGroups(): Flow<List<Group>>
}