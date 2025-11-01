package com.example.duolingo.presentation.main

import android.graphics.BitmapFactory
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.ProfileRepository
import com.example.duolingo.domain.usecase.CustomResult
import com.example.duolingo.domain.usecase.getOrNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val profileRepository: ProfileRepository

) : ViewModel() {
    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    private val _profile = MutableStateFlow<ProfileModel?>(null)
    val profile: StateFlow<ProfileModel?> = _profile
    private val _avatarBitmap = MutableStateFlow<ImageBitmap?>(null)
    val avatarBitmap: StateFlow<ImageBitmap?> = _avatarBitmap

    //    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            getProfile()
//        }
//    }
    fun loadAvatar(imageUrl: String) {
        viewModelScope.launch {
            val bitmap = withContext(Dispatchers.IO) {
                // HTTP загрузка картинки
                try {
                    val url = URL(imageUrl)
                    val connection = url.openConnection() as HttpURLConnection
                    val input = connection.inputStream
                    BitmapFactory.decodeStream(input)?.asImageBitmap()
                } catch (e: Exception) {
                    _state.value = state.value.copy(
                        errorMessage = e.message
                    )
                    null
                }
            }
            _avatarBitmap.value = bitmap
        }
    }

    fun loadProfile(id: String) {
        viewModelScope.launch {
            try {
                when (val result = profileRepository.getProfileById(id)) {
                    is CustomResult.Success -> {
                        _state.value = state.value.copy(
                            profileModel = result.getOrNull()
                        )
                    }

                    is CustomResult.Error -> {
                        _state.value = state.value.copy(
                            errorMessage = result.message
                        )
                    }
                }
            } catch (e: Exception) {
                _state.value = state.value.copy(
                    errorMessage = "Failed to load profile: ${e.message}"
                )
            }
        }
    }

    private suspend fun getProfile() {
    }

    fun onEvent(event: MainEvents) {
    }

}