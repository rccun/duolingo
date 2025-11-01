package com.example.duolingo.data.mappers

import com.example.duolingo.data.dto.ProfileModelDto
import com.example.duolingo.domain.model.ProfileModel

fun ProfileModelDto.toModel() =
    ProfileModel(id, email, password, firstName, lastName, avatarUrl)