package com.example.duolingo.presentation.sign_up

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duolingo.domain.usecase.Auth.SignUpUseCase
import com.example.duolingo.domain.usecase.Queue.Auth.ValidateEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val signUpUseCase: SignUpUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun onEvent(event: SignUpEvents) {
        when (event) {
            is SignUpEvents.OnEmailValueChange -> {
                _state.value = state.value.copy(
                    email = event.value,
                )
            }

            is SignUpEvents.OnFirstNameValueChange -> {
                _state.value = state.value.copy(
                    firstName = event.value,
                )
            }

            is SignUpEvents.OnLastNameValueChange -> {
                _state.value = state.value.copy(
                    lastName = event.value,
                )
            }
            is SignUpEvents.OnPasswordValueChange -> {
                _state.value = state.value.copy(
                    password = event.value,
                )
            }
            is SignUpEvents.OnConfPasswordValueChange -> {
                _state.value = state.value.copy(
                    confPassword = event.value,
                )
            }
            is SignUpEvents.OnTermsClick -> {
                _state.value = state.value.copy(
                    accepted = event.value,
                )
            }
            SignUpEvents.OnNextClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val result = validateEmailUseCase.execute(
                        email = _state.value.email
                    )
                    //Log.d("TAG123", result.message.toString())
                    Log.d("TAG123", result.isValid.toString())
                    _state.value = state.value.copy(
                        errorMessage = result.message,
                        isEmailValid = result.isValid
                    )
                    //Log.d("TAG1234", _state.value.errorMessage)
                }
            }

            SignUpEvents.OnSignUpClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = signUpUseCase.execute(
                        password = _state.value.password,
                        firstName = _state.value.firstName,
                        lastName = _state.value.lastName,
                        email = _state.value.email,
                        confPassword = _state.value.confPassword,
                        acceptedTerms = _state.value.accepted
                    )
                    _state.value = state.value.copy(
                        isSuccess = res.isValid,
                        errorMessage = res.message
                    )
                }
            }
            SignUpEvents.OnBackClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        isEmailValid = false
                    )
                }
            }
        }
    }
}