package com.example.duolingo.domain.utils

import com.example.duolingo.domain.usecase.CustomResult

interface EmailValidator {
    fun validateEmail(email: String) : CustomResult<Unit>
}