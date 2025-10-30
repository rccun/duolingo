package com.example.duolingo.domain.utils

import com.example.duolingo.domain.usecase.Queue.ValidationResult

interface PasswordValidator {
    fun validatePassword(passw: String) : Result<ValidationResult>
}