package com.example.test.presentation.onboard

sealed interface OnBoardEvent {

    data class OnNextButtonClick(val nextIndex: Int): OnBoardEvent
}