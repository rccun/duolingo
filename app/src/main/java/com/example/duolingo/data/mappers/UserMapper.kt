package com.example.duolingo.data.mappers

import com.example.duolingo.data.dto.UserModelDto
import com.example.duolingo.domain.model.UserModel

fun UserModelDto.toModel() =
    UserModel(id, email, firstName, lastName)