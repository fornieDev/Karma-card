package com.example.karmacard.di

import android.content.Context
import androidx.room.Room
import com.example.karmacard.data.dataSource.local.AppDatabase
import com.example.karmacard.data.dataSource.local.dao.GroupDao
import com.example.karmacard.data.dataSource.remote.api.GroupApi
import com.example.karmacard.data.repositoryImp.GroupRepositoryImpl
import com.example.karmacard.domain.repositoryInt.GroupRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app-db").build()

    @Provides
    @Singleton
    fun provideGroupDao(db: AppDatabase): GroupDao = db.groupDao()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://tu-api.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGroupApi(retrofit: Retrofit): GroupApi =
        retrofit.create(GroupApi::class.java)

    @Provides
    @Singleton
    fun provideGroupRepository(dao: GroupDao, api: GroupApi): GroupRepository =
        GroupRepositoryImpl(dao, api)
}