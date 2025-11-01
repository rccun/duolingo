package com.example.duolingo.data.utils

import android.util.Patterns
import com.example.duolingo.domain.usecase.CustomResult
import com.example.duolingo.domain.utils.EmailValidator

class EmailValidatorImpl : EmailValidator{
    override fun validateEmail(email: String): CustomResult<Unit> {
        if (email == "") {
            return CustomResult.Error("Email не должен быть пустым")
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return CustomResult.Error( "Введите корректный email")
        }
        return CustomResult.Success(Unit)
    }
}