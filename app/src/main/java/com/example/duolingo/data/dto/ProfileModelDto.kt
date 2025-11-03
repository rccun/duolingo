package com.example.duolingo.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.duolingo.domain.model.ProfileModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class ProfileModelDto(
    @PrimaryKey val id: String,
    @SerializedName("first_name") val firstName: String,
    val email: String,
    val password: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("avatar_url") val avatarUrl: String = "https://cdkxhfvlaartfvdsrjlz.supabase.co/storage/v1/object/public/avatars/placeholder.png",
    val score: Int = 0,
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
        avatarUrl = avatarUrl,
        score = score
    )