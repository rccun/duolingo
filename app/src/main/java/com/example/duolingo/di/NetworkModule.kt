package com.example.duolingo.di

import com.example.duolingo.data.api.SupabaseAuthApi
import com.example.duolingo.data.api.SupabaseRestApi
import com.example.duolingo.data.data_source.SupabaseHttpClients
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
    fun provideSupabaseRestApi(): SupabaseRestApi {
        return SupabaseHttpClients.restApi
    }
    @Provides
    @Singleton
    fun provideSupabaseAuthApi(): SupabaseAuthApi {
        return SupabaseHttpClients.authApi
    }

}
