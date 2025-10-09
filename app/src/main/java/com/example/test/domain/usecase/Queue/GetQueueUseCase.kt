package com.example.test.domain.usecase.Queue

import com.example.test.domain.repository.QueueRepository

class GetQueueUseCase(
    private val queueRepository: QueueRepository
) {

    suspend operator fun invoke() =
        queueRepository.getQueue()
}