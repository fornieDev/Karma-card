package com.example.karmacard.data.mapper

import com.example.karmacard.domain.model.Group
import com.example.karmacard.data.dataSource.local.entity.GroupEntity
import com.example.karmacard.data.dataSource.remote.dto.GroupDto

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

fun GroupEntity.toDto(): GroupDto =
    GroupDto(id = id, name = name)