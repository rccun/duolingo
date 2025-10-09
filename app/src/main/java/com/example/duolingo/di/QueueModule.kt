package com.example.test.di

import android.content.Context
import com.example.test.data.repository.QueueRepositoryImpl
import com.example.test.domain.repository.QueueRepository
import com.example.test.domain.usecase.Queue.GetQueueUseCase
import com.example.test.domain.usecase.Queue.SetQueueUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QueueModule {

    @Provides
    @Singleton
    fun provideQueueRepository(@ApplicationContext context: Context): QueueRepository {
        return QueueRepositoryImpl(context)
    }


    @Provides
    @Singleton
    fun provideGetQueueUseCase(queueRepository: QueueRepository) =
        GetQueueUseCase(queueRepository)
    @Provides
    @Singleton
    fun provideSetQueueUseCase(queueRepository: QueueRepository) =
        SetQueueUseCase(queueRepository)


}