package com.example.karmacard.data.dataSource.remote.api

import com.example.karmacard.data.dataSource.remote.dto.GroupDto
import retrofit2.http.Body
import retrofit2.http.POST

interface GroupApi {
    @POST("groups")
    suspend fun createGroup(@Body group: GroupDto)
}