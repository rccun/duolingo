package com.example.duolingo.presentation.main

import com.example.duolingo.domain.model.ExerciseModel
import com.example.duolingo.domain.model.ProfileModel

data class MainState(
    val profileModel: ProfileModel? = null,
    val isLoading: Boolean = false,
    val topUsers: List<ProfileModel>? = null,
    val exercises: List<ExerciseModel>? = null,
    val errorMessage: String? = null
)
