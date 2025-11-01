package com.example.duolingo.data.data_source

import com.example.duolingo.data.api.SupabaseApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SupabaseHttpClient {
    const val SUPABASE_URL = "https://cdkxhfvlaartfvdsrjlz.supabase.co"
    const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNka3hoZnZsYWFydGZ2ZHNyamx6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjA1NjIyNjMsImV4cCI6MjA3NjEzODI2M30.dsOQvtArgtLy981-We_RdAOEPGXIiY7xFbhjRNc7sZk" // из настроек проекта
    const val API_VERSION = "v1"
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("apikey", SUPABASE_KEY)
                .header("Authorization", "Bearer $SUPABASE_KEY")
                .header("Content-Type", "application/json")
                .header("Prefer", "return=representation") // возвращать данные после insert/update
                .build()
            chain.proceed(request)
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("$SUPABASE_URL/rest/$API_VERSION/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: SupabaseApi = retrofit.create(SupabaseApi::class.java)

}