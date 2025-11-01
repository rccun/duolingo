package com.example.duolingo.domain.usecase.Auth

import com.example.duolingo.domain.usecase.CustomResult

class ValidateUseCase(
    private val passwordValidation: ValidatePasswordUseCase,
    private val confirmPasswordUseCase: ValidateConfirmPasswordUseCase,
    private val termsUseCase: ValidateTermsUseCase
) {
    fun execute(password: String, confPassword: String, acceptedTerms: Boolean ): CustomResult<Unit> {
        val resValidationPassword = passwordValidation.execute(password)
        val resValidationConfPassword = confirmPasswordUseCase.execute(password, confPassword)

        if (!resValidationPassword.isValid) {
            return resValidationPassword
        } else if (!resValidationConfPassword.isValid) {
            return resValidationConfPassword
        }

        val resAccepted = termsUseCase.execute(acceptedTerms)
        if (!resAccepted.isValid) {
            return resAccepted
        }
        return CustomResult.Success(Unit)
    }
}