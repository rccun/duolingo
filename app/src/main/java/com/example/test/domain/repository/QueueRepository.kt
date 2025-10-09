package com.example.test.domain.repository

interface QueueRepository {

    suspend fun getQueue(): Int
    suspend fun setQueue(value: Int)
}