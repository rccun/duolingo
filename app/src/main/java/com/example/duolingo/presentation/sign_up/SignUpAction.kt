package com.example.duolingo.presentation.sign_up

sealed interface SignUpAction {
    data object OnSuccessSignUp : SignUpAction

    data class OnError(val message: String): SignUpAction
}