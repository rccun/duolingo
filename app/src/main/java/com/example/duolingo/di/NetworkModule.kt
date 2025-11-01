package com.example.duolingo.di

import com.example.duolingo.data.api.SupabaseApi
import com.example.duolingo.data.data_source.SupabaseHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideSupabaseApi(): SupabaseApi {
        return SupabaseHttpClient.api
    }
}
