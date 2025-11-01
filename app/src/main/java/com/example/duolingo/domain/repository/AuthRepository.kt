package com.example.duolingo.domain.repository

import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.usecase.CustomResult

interface AuthRepository {

    suspend fun signIn(email: String, password: String): CustomResult<ProfileModel>
    suspend fun signUp(email: String, password: String, firstName: String, lastName: String): CustomResult<ProfileModel>
    suspend fun getCurrentUser() : ProfileModel
}