package com.example.karmacard.data.repositoryImp

import com.example.karmacard.data.dataSource.local.dao.GroupDao
import com.example.karmacard.data.mapper.toDomain
import com.example.karmacard.data.mapper.toEntity
import com.example.karmacard.data.dataSource.remote.api.GroupApi
import com.example.karmacard.domain.model.Group
import com.example.karmacard.domain.repositoryInt.GroupRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import com.example.karmacard.core.result.Result
import com.example.karmacard.core.error.toAppError
import com.example.karmacard.data.mapper.toDto

class GroupRepositoryImpl(
    private val dao: GroupDao,
    private val api: GroupApi,
    private val dispatcher: CoroutineDispatcher
) : GroupRepository {

    override suspend fun createGroup(group: Group) : Result <Unit> {
        return withContext(dispatcher) {

            try {
                dao.insertGroup(group.toEntity().copy(isSynced = false))

                Result.Success(Unit)

            } catch (e: Exception) {

                Result.Error(e.toAppError())
            }
        }
    }

    override fun getGroups(): Flow<List<Group>> {
        return dao.getGroups().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun syncPendingGroups(): Result<Unit> {
        return withContext(dispatcher) {
            try {
                val pending = dao.getUnsyncedGroups()
                pending.forEach { entity ->
                    api.createGroup(entity.toDto())
                    dao.markAsSynced(entity.id)
                }
                Result.Success(Unit)
            } catch (e: Exception) {
                Result.Error(e.toAppError())
            }
        }
    }
}