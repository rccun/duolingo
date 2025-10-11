package com.example.duolingo.presentation.onboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(): ViewModel() {

    fun onEvent(event: OnBoardEvent) {
        when (event) {
            is OnBoardEvent.OnNextButtonClick -> TODO()
        }
    }
}