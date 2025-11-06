package com.example.duolingo.domain.repository

import com.example.duolingo.domain.usecase.CustomResult

interface GuessRepository {
    suspend fun getAnimalUrl(): CustomResult<String>
}