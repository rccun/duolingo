package com.example.test.domain.usecase.Queue

import com.example.test.domain.repository.QueueRepository

class SetQueueUseCase(
    private val queueRepository: QueueRepository
) {

    suspend operator fun invoke(value: Int) =
        queueRepository.setQueue(value)
}