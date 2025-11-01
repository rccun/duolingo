package com.example.duolingo.domain.repository

import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.usecase.CustomResult
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getProfileFlow(): Flow<CustomResult<ProfileModel>>
    suspend fun getProfileById(id: String): CustomResult<ProfileModel>
}