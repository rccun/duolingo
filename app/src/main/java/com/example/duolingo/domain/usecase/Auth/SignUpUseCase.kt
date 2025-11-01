package com.example.duolingo.domain.usecase.Auth

import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.AuthRepository
import com.example.duolingo.domain.usecase.CustomResult

class SignUpUseCase(
    private val repo: AuthRepository,

) {
    suspend fun execute(email: String, password: String, firstName: String, lastName: String) : CustomResult<ProfileModel> {
        return repo.signUp(email, password, firstName, lastName)
    }
}