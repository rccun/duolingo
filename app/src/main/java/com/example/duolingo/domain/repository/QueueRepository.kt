package com.example.duolingo.domain.repository

interface QueueRepository {

    suspend fun getQueue(): Int
    suspend fun setQueue(value: Int)
}