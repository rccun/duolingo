package com.example.duolingo.data.dto

import com.example.duolingo.data.mappers.toModel
import com.example.duolingo.domain.model.UserModel
import kotlinx.serialization.Serializable

@Serializable
data class UserModelDto(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
)


class RepoImpl {

    suspend fun toDo(): /*Blablabla < */UserModel {
        return UserModelDto(0, "", "", "").toModel()
    }
}