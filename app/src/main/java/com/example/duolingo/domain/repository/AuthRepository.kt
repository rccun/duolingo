package com.example.duolingo.domain.repository

import com.example.duolingo.domain.usecase.Queue.ValidationResult

interface AuthRepository {

    suspend fun signIn(email: String, password: String): ValidationResult
    suspend fun signUp(email: String, password: String, firstName: String, lastName: String): ValidationResult

}