package com.example.karmacard.core.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.karmacard.core.data.remote.api.GroupApi
import com.example.karmacard.core.data.repository.GroupRepositoryImpl
import com.example.karmacard.core.data.local.AppDatabase
import com.example.karmacard.core.domain.useCase.CreateGroupUseCase
import com.example.karmacard.core.domain.useCase.GetGroupsUseCase
import com.example.karmacard.core.ui.viewmodel.HomeViewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HomeView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app-db"
        ).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://tu-api.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val api = retrofit.create(GroupApi::class.java)

        val repository = GroupRepositoryImpl(
            dao = db.groupDao(),
            api = api
        )

        val createGroupUseCase = CreateGroupUseCase(repository)
        val getGroupsUseCase = GetGroupsUseCase(repository)

        val viewModel = HomeViewModel(createGroupUseCase, getGroupsUseCase)


        setContent {
            HomeScreen(viewModel)
        }
    }
}

