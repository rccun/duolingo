package com.example.duolingo.presentation.onboard

sealed interface OnBoardEvent {

    data class OnNextButtonClick(val nextIndex: Int): OnBoardEvent
}