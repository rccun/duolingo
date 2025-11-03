package com.example.duolingo.di

import com.example.duolingo.data.api.SupabaseRestApi
import com.example.duolingo.data.repository.MainRepositoryImpl
import com.example.duolingo.domain.repository.MainRepository
import com.example.duolingo.domain.usecase.main.GetExercisesUseCase
import com.example.duolingo.domain.usecase.main.GetTopProfilesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideMainRepository(api: SupabaseRestApi): MainRepository =
        MainRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetTopProfilesUseCase(repo: MainRepository) =
        GetTopProfilesUseCase(repo)
    @Provides
    @Singleton
    fun provideGetExercisesUseCase(repo: MainRepository) =
        GetExercisesUseCase(repo)
}