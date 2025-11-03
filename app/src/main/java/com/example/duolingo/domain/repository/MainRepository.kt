package com.example.duolingo.domain.repository

import com.example.duolingo.domain.model.ExerciseModel
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.usecase.CustomResult

interface MainRepository {
    suspend fun getTopProfiles(): CustomResult<List<ProfileModel>>
    suspend fun getExercises(): CustomResult<List<ExerciseModel>>
}