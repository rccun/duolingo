package com.example.duolingo.domain.usecase.Queue

import com.example.duolingo.domain.repository.QueueRepository

class SetQueueUseCase(
    private val queueRepository: QueueRepository
) {

    suspend operator fun invoke(value: Int) =
        queueRepository.setQueue(value)
}