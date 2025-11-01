package com.example.duolingo.domain.usecase.Auth

import com.example.duolingo.domain.usecase.CustomResult

class ValidateTermsUseCase {
    fun execute(accepted: Boolean): CustomResult<Unit>  {
        if (!accepted) return CustomResult.Error("Согласитесь с условиями использования")
        return CustomResult.Success(Unit)
    }
}