package com.example.karmacard.data.dataSource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.karmacard.data.dataSource.local.dao.GroupDao
import com.example.karmacard.data.dataSource.local.entity.GroupEntity

@Database(entities = [GroupEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun groupDao(): GroupDao
}