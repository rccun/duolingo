package com.example.duolingo.data.dto

import com.example.duolingo.domain.model.ExerciseModel
import com.google.gson.annotations.SerializedName

data class ExerciseModelDto(
    val id: String,
    val title: String,
    @SerializedName("image_url") val imageUrl: String,
    val color: Int,
    val icon: String
)

fun ExerciseModelDto.toDomain() : ExerciseModel =
    ExerciseModel (
        id = id,
        title = title,
        color = color,
        imageUrl = imageUrl,
        icon = icon
    )