package com.example.karmacard.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.karmacard.core.data.local.dao.GroupDao
import com.example.karmacard.core.data.local.entity.GroupEntity

@Database(entities = [GroupEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun groupDao(): GroupDao
}