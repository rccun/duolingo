package com.example.duolingo.di

import com.example.duolingo.data.api.SupabaseRestApi
import com.example.duolingo.data.repository.ProfileRepositoryImpl
import com.example.duolingo.domain.repository.ProfileRepository
import com.example.duolingo.domain.usecase.profile.GetProfileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {

    @Provides
    @Singleton
    fun provideProfileRepository(api: SupabaseRestApi): ProfileRepository =
        ProfileRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetProfileUseCase(repo: ProfileRepository) =
        GetProfileUseCase(repo)
}