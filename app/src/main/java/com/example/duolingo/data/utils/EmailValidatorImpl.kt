package com.example.duolingo.data.utils

import android.util.Patterns
import com.example.duolingo.domain.usecase.Queue.ValidationResult
import com.example.duolingo.domain.utils.EmailValidator

class EmailValidatorImpl : EmailValidator{
    override fun validateEmail(email: String): ValidationResult {
        if (email == "") {
            return ValidationResult(false, "Email не должен быть пустым")
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(false, "Введите корректный email")
        }
        return ValidationResult(true)
    }
}