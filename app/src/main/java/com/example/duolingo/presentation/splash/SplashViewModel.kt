package com.example.test.presentation.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.usecase.Queue.GetQueueUseCase
import com.example.test.domain.usecase.Queue.SetQueueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getQueueUseCase: GetQueueUseCase,
    private val setQueueUseCase: SetQueueUseCase
): ViewModel() {

    private val _state = mutableStateOf(SplashState())
    val state: State<SplashState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)

            val isQueueOut = getQueueUseCase.invoke() != -1

            withContext(Dispatchers.Main) {
                _state.value = state.value.copy(
                    isTimeOut = true
                )
            }
        }
    }
}