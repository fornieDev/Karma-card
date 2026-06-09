package com.example.karmacard.ui.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.karmacard.core.components.buttons.AddButton
import com.example.karmacard.core.components.dialogs.CreateItemDialog
import com.example.karmacard.ui.viewmodel.HomeEvent
import com.example.karmacard.ui.viewmodel.HomeViewModel
import com.example.karmacard.core.error.AppError

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val groups by viewModel.groups.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is HomeEvent.GroupCreated -> {
                    snackbarHostState.showSnackbar(
                        message = "Grupo creado correctamente"
                    )
                }

                is HomeEvent.Error -> {

                    val message = when (event.error) {

                        AppError.Network -> "Sin conexión a internet"

                        AppError.Database -> "Error en la base de datos"

                        AppError.Unauthorized -> "No autorizado"

                        AppError.NotFound -> "No encontrado"

                        is AppError.Unknown -> "Error desconocido"
                    }

                    snackbarHostState.showSnackbar(message)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },

        floatingActionButton = {
            AddButton(
                onClick = { showDialog = true }
            )
        }
    ) { padding ->
        if (groups.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No tienes grupos")
            }

        } else {

            LazyColumn(modifier = Modifier.padding(padding)) {
                items(groups) { group ->
                    Text(group.name)
                }
            }
        }

        if (showDialog) {
            CreateItemDialog(
                title = "Nuevo Grupo",
                label = "Nombre del grupo",
                onDismiss = { showDialog = false },
                onCreate = { name ->
                    viewModel.onAddGroupClicked(name)
                    showDialog = false
                }
            )
        }
    }
}