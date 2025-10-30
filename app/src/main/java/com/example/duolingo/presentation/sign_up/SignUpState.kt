package com.example.duolingo.presentation.sign_up

data class SignUpState(
    val isEmailValid: Boolean? = null,
    val isSuccess: Boolean? = null,
    val email: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",
    val confPassword: String = "",
    val accepted: Boolean = false,
    val errorMessage: String = ""
)