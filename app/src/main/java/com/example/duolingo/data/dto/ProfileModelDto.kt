package com.example.duolingo.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.duolingo.domain.model.ProfileModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.Serial

@Entity
@Serializable
data class ProfileModelDto(
    @PrimaryKey val id: String,
    val email: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    val password: String,
    @SerialName("avatar_url") val avatarUrl: String
)


//fun ProfileModel.toProfileModelDto() : ProfileModelDto =
//    ProfileModelDto(
//        id = id,
//        email = email,
//        password = password,
//        firstName = firstName,
//        lastName = lastName
//    )
fun ProfileModelDto.toDomain() : ProfileModel =
    ProfileModel (
        id = id,
        email = email,
        password = password,
        firstName = firstName,
        lastName = lastName,
        avatarUrl = avatarUrl
    )