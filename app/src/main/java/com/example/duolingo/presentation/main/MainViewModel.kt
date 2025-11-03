package com.example.duolingo.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duolingo.domain.usecase.CustomResult
import com.example.duolingo.domain.usecase.getOrNull
import com.example.duolingo.domain.usecase.main.GetExercisesUseCase
import com.example.duolingo.domain.usecase.main.GetTopProfilesUseCase
import com.example.duolingo.domain.usecase.profile.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val getExercisesUseCase: GetExercisesUseCase,
    private val getTopProfilesUseCase: GetTopProfilesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(MainState(isLoading = true))
    val state: StateFlow<MainState> = _state

    fun loadExercises() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true
            )
            try {
                when (val result = getExercisesUseCase.execute()) {
                    is CustomResult.Success -> {
                        val exercises = result.getOrNull()
                        _state.value = _state.value.copy(
                            exercises = exercises,
                            isLoading = false
                        )
                    }

                    is CustomResult.Error -> {
                        _state.value = _state.value.copy(
                            errorMessage = result.message,
                            isLoading = false
                        )
                    }

                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    errorMessage = e.message,
                    isLoading = false
                )
            }
        }
    }
    fun loadProfile(id: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                when (val result = getProfileUseCase.execute(id)) {
                    is CustomResult.Success -> {
                        val profile = result.getOrNull()
                        _state.value = _state.value.copy(
                            profileModel = profile,
                            isLoading = false
                        )
                    }

                    is CustomResult.Error -> {
                        _state.value = _state.value.copy(
                            errorMessage = result.message,
                            isLoading = false
                        )
                    }
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    errorMessage = e.message,
                    isLoading = false
                )
            }
        }
    }

    //    private fun loadAvatar(url: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val bitmap = try {
//                val connection = URL(url).openConnection() as HttpURLConnection
//                val input = connection.inputStream
//                BitmapFactory.decodeStream(input)?.asImageBitmap()
//            } catch (e: Exception) {
//                null
//            }
//            _state.value = _state.value.copy(avatar = bitmap)
//        }
//    }
    fun loadProfiles() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                when (val result = getTopProfilesUseCase.execute()) {
                    is CustomResult.Success -> {
                        val topProfiles = result.getOrNull()
                        _state.value = _state.value.copy(
                            topUsers = topProfiles,
                            isLoading = false
                        )
                    }

                    is CustomResult.Error -> {
                        _state.value = _state.value.copy(
                            errorMessage = result.message,
                            isLoading = false
                        )
                    }
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    errorMessage = e.message,
                    isLoading = false
                )
            }
        }
    }
}