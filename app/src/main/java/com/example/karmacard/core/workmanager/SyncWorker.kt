package com.example.karmacard.core.workmanager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.karmacard.domain.repositoryInt.GroupRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import com.example.karmacard.core.result.Result as AppResult

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val repository: GroupRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return when (val result = repository.syncPendingGroups()) {
            is AppResult.Success -> Result.success()
            is AppResult.Error   -> Result.retry()
        }
    }
}