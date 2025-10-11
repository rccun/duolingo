package com.example.duolingo.domain.usecase.Queue

import com.example.duolingo.domain.repository.QueueRepository

class GetQueueUseCase(
    private val queueRepository: QueueRepository
) {

    suspend operator fun invoke() =
        queueRepository.getQueue()
}