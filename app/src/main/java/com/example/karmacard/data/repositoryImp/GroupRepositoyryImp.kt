package com.example.karmacard.data.repositoryImp

import com.example.karmacard.data.dataSource.local.dao.GroupDao
import com.example.karmacard.data.mapper.toDomain
import com.example.karmacard.data.mapper.toEntity
import com.example.karmacard.data.dataSource.remote.api.GroupApi
import com.example.karmacard.domain.model.Group
import com.example.karmacard.domain.repositoryInt.GroupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GroupRepositoryImpl(
    private val dao: GroupDao,
    private val api: GroupApi
) : GroupRepository {

    override suspend fun createGroup(group: Group) {

        // offline-first → guardar primero en Room
        dao.insertGroup(group.toEntity())

        try {
            //api.createGroup(group.toDto())
        } catch (e: Exception) {
            // ignoramos error si no hay internet
        }
    }

    //De momento sólo escritura
    /*
    override suspend fun getGroups(): List<Group> {
        return dao.getGroups().map { it.toDomain() }
    }
    */
    override fun getGroups(): Flow<List<Group>> {
        return dao.getGroups().map { list ->
            list.map { it.toDomain() }
        }
    }
}