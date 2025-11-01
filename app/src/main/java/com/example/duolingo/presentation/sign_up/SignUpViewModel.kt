package com.example.duolingo.presentation.sign_up

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duolingo.domain.usecase.Auth.SignUpUseCase
import com.example.duolingo.domain.usecase.Auth.ValidateEmailUseCase
import com.example.duolingo.domain.usecase.Auth.ValidateUseCase
import com.example.duolingo.domain.usecase.getOrNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val signUpUseCase: SignUpUseCase,
    private val validateUseCase: ValidateUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    private val _channel = Channel<SignUpAction>()
    val channel = _channel.receiveAsFlow()

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
                    _state.value = state.value.copy(
                        errorMessage = result.errorMessage
                    )

                    if (result.isValid) {
                        _channel.send(SignUpAction.OnSuccessSignUp)
                    } else {
                        _channel.send(SignUpAction.OnError("Email invalid!"))
                    }
                }

            }

            SignUpEvents.OnSignUpClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = validateUseCase.execute(
                        password = _state.value.password,
                        confPassword = _state.value.confPassword,
                        acceptedTerms = _state.value.accepted
                    )
                    if (res.isValid) {
                        val result = signUpUseCase.execute(
                            password = _state.value.password,
                            firstName = _state.value.firstName,
                            lastName = _state.value.lastName,
                            email = _state.value.email
                        )


                        var _id = ""
                        if (result.isValid) {
                            _id =  result.getOrNull()!!.id
                        }
                        _state.value = state.value.copy(
                            id = _id,
                            isSuccess = result.isValid,
                            errorMessage = result.errorMessage
                        )
                    } else {
                        _state.value = state.value.copy(
                            isSuccess = res.isValid,
                            errorMessage = res.errorMessage
                        )
                    }
                }
            }
        }
    }
}