package com.example.karmacard.data.dataSource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupDto(

    @SerialName("group_id")
    val id: Long = 0,

    @SerialName("group_name")
    val name: String
)