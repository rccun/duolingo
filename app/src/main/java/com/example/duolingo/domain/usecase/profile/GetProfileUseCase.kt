package com.example.duolingo.domain.usecase.profile

import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.ProfileRepository
import com.example.duolingo.domain.usecase.CustomResult

class GetProfileUseCase(
    private val repo: ProfileRepository
) {
    suspend fun execute(id: String): CustomResult<ProfileModel> {
        return repo.getProfileById(id)
    }
}