package com.example.duolingo.domain.model

data class ProfileModel(
    val id: String,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val avatarUrl: String = "https://cdkxhfvlaartfvdsrjlz.supabase.co/storage/v1/object/public/avatars/placeholder.png",
    val score: Int
)
