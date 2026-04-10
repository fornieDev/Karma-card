package com.example.karmacard.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.karmacard.core.data.local.entity.GroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao {
    @Insert
    suspend fun insertGroup(group: GroupEntity)

    //De momento sólo escritura
    //@Query("SELECT * FROM groups")
    //suspend fun getGroups(): List<GroupEntity>

    @Query("SELECT * FROM `groups`")
    fun getGroups(): Flow<List<GroupEntity>>
}