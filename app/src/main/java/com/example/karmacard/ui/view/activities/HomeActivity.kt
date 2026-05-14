package com.example.karmacard.ui.view.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.room.Room
import com.example.karmacard.data.dataSource.remote.api.GroupApi
import com.example.karmacard.data.repositoryImp.GroupRepositoryImpl
import com.example.karmacard.data.dataSource.local.AppDatabase
import com.example.karmacard.domain.useCase.CreateGroupUseCase
import com.example.karmacard.domain.useCase.GetGroupsUseCase
import com.example.karmacard.ui.view.screens.HomeScreen
import com.example.karmacard.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
@AndroidEntryPoint
class HomeView : ComponentActivity() {

    //private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /*

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

         */

        setContent {
            HomeScreen()
        }
    }
}

