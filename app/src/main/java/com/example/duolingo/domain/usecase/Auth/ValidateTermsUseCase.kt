package com.example.duolingo.domain.usecase.Auth

import com.example.duolingo.domain.usecase.Queue.ValidationResult

class ValidateTermsUseCase {
    fun execute(accepted: Boolean): ValidationResult  {
        if (!accepted) return ValidationResult(false, "Согласитесь с условиями использования")
        return ValidationResult(true)
    }
}