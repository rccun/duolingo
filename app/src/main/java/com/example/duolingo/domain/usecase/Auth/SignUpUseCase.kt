package com.example.duolingo.domain.usecase.Auth

import android.util.Log
import com.example.duolingo.domain.repository.AuthRepository
import com.example.duolingo.domain.usecase.Queue.Auth.ValidateConfirmPasswordUseCase
import com.example.duolingo.domain.usecase.Queue.Auth.ValidateEmailUseCase
import com.example.duolingo.domain.usecase.Queue.ValidationResult

class SignUpUseCase(
    private val repo: AuthRepository,
    private val passwordValidation: ValidatePasswordUseCase,
    private val confirmPasswordUseCase: ValidateConfirmPasswordUseCase,
    private val termsUseCase: ValidateTermsUseCase

) {
    suspend fun execute(email: String, password: String, confPassword: String, firstName: String, lastName: String, acceptedTerms: Boolean ) : ValidationResult {

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

        return repo.signUp(email, password, firstName, lastName)
    }
}