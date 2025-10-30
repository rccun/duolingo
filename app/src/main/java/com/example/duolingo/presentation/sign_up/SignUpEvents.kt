package com.example.duolingo.presentation.sign_up

interface SignUpEvents {
    data class OnEmailValueChange(val value: String) : SignUpEvents
    data class OnFirstNameValueChange(val value: String) : SignUpEvents
    data class OnLastNameValueChange(val value: String) : SignUpEvents
    data class OnPasswordValueChange(val value: String) : SignUpEvents
    data class OnConfPasswordValueChange(val value: String) : SignUpEvents
    data class OnTermsClick(val value: Boolean) : SignUpEvents
    data object OnNextClick : SignUpEvents
    data object OnBackClick : SignUpEvents
    data object OnSignUpClick : SignUpEvents
}