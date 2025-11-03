package com.example.duolingo.domain.usecase.main

import com.example.duolingo.domain.model.ExerciseModel
import com.example.duolingo.domain.repository.MainRepository
import com.example.duolingo.domain.usecase.CustomResult

class GetExercisesUseCase(
    private val repo: MainRepository
) {
    suspend fun execute(): CustomResult<List<ExerciseModel>> {
        return repo.getExercises()
    }
}