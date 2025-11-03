package com.example.duolingo.data.data_source

import android.util.Log
import com.example.duolingo.data.api.SupabaseAuthApi
import com.example.duolingo.data.api.SupabaseRestApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object SupabaseHttpClients {
    private const val BASE_URL = "https://cdkxhfvlaartfvdsrjlz.supabase.co/"

    const val SUPABASE_URL = "https://cdkxhfvlaartfvdsrjlz.supabase.co"

    const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNka3hoZnZsYWFydGZ2ZHNyamx6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjA1NjIyNjMsImV4cCI6MjA3NjEzODI2M30.dsOQvtArgtLy981-We_RdAOEPGXIiY7xFbhjRNc7sZk" // из настроек проекта
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Логирование всех данных тела запроса и ответа
    }
    // Клиент для Auth API
    val authApi: SupabaseAuthApi = Retrofit.Builder()
        .baseUrl(BASE_URL) // Без /rest/v1/
        .client(createHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SupabaseAuthApi::class.java)

    // Клиент для REST API
    val restApi: SupabaseRestApi = Retrofit.Builder()
        .baseUrl("${BASE_URL}rest/v1/") // С /rest/v1/
        .client(createHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SupabaseRestApi::class.java)
    private fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request()
                Log.d("FULL_URL", "🎯 Request URL: ${request.url}")
                chain.proceed(request)
            }
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("apikey", SUPABASE_KEY)
                    .header("Authorization", "Bearer $SUPABASE_KEY")
                    .header("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            }
            .build()
    }
    const val API_VERSION = "v1"
//    private val okHttpClient = OkHttpClient.Builder()
//        // В Interceptor
//
//        .addInterceptor { chain ->
//            val original = chain.request()
//            val request = original.newBuilder()
//                .header("apikey", SUPABASE_KEY)
//                .header("Authorization", "Bearer $SUPABASE_KEY")
//                .header("Content-Type", "application/json")
//                .header("Prefer", "return=representation") // возвращать данные после insert/update
//                .build()
//            chain.proceed(request)
//        }
//        .addInterceptor(HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        })
//        .build()

//    private val retrofit = Retrofit.Builder()
//        .baseUrl("$SUPABASE_URL/")
//        .client(okHttpClient)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

    //val api: SupabaseRestApi = retrofit.create(SupabaseRestApi::class.java)

}
