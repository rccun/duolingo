package com.example.duolingo.domain.usecase.main

import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.MainRepository
import com.example.duolingo.domain.usecase.CustomResult

class GetTopProfilesUseCase(
    private val repo: MainRepository
) {
    suspend fun execute(): CustomResult<List<ProfileModel>> {
        return repo.getTopProfiles()
    }
}