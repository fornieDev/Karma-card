package com.example.karmacard.core.data.mapper

import com.example.karmacard.core.domain.model.Group
import com.example.karmacard.core.data.local.entity.GroupEntity
import com.example.karmacard.core.data.remote.dto.GroupDto

fun Group.toEntity(): GroupEntity =
    GroupEntity(
        id = id,
        name = name
    )

fun GroupEntity.toDomain(): Group =
    Group(
        id = id,
        name = name
    )

fun Group.toDto(): GroupDto =
    GroupDto(
        id = id,
        name = name
    )

fun GroupDto.toDomain(): Group =
    Group(
        id = id,
        name = name
    )