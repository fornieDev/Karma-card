package com.example.karmacard.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.karmacard.data.dataSource.local.entity.GroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao {
    @Insert
    suspend fun insertGroup(group: GroupEntity)

    @Query("SELECT * FROM `groups`")
    fun getGroups(): Flow<List<GroupEntity>>

    @Query("SELECT * FROM `groups` WHERE is_synced = 0")
    suspend fun getUnsyncedGroups(): List<GroupEntity>

    @Query("UPDATE `groups` SET is_synced = 1 WHERE id = :id")
    suspend fun markAsSynced(id: Long)
}