package com.example.duolingo.domain.model

data class ExerciseModel(
    val id: String,
    val title: String,
    val imageUrl: String = "https://cdkxhfvlaartfvdsrjlz.supabase.co/storage/v1/object/public/avatars/placeholder.png",
    val color: Int,
    val icon: String
)
