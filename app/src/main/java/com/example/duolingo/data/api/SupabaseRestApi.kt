package com.example.duolingo.data.api

import com.example.duolingo.data.dto.ExerciseModelDto
import com.example.duolingo.data.dto.ProfileModelDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

// data/api/SupabaseApi.kt
interface SupabaseRestApi {

    // GET - получение всех пользователей
    @GET("profiles")
    suspend fun getProfiles(
        @Query("select") select: String? = "*",
        @Query("limit") limit: Int? = null,
        @Query("order") order: String? = null
    ): Response<List<ProfileModelDto>>
    @GET("exercises")
    suspend fun getExercises(
        @Query("select") select: String? = "*",
        @Query("limit") limit: Int? = null,
        @Query("order") order: String? = null
    ): Response<List<ExerciseModelDto>>

    // GET - получение пользователя по ID
    @GET("profiles")
    suspend fun getProfileById(
        @Query("id") id: String,
        @Query("select") select: String? = "*"
    ): Response<List<ProfileModelDto>>

    // POST - создание пользователя
    @POST("profiles")
    suspend fun createProfile(
        @Body request: ProfileModelDto
    ): Response<Unit>

    // PATCH - обновление пользователя
    @PATCH("profiles")
    suspend fun updateProfile(
        @Query("id") id: String,
        @Body updates: Map<String, Any>
    ): Response<Unit>

    // DELETE - удаление пользователя
    @DELETE("profiles")
    suspend fun deleteProfile(
        @Query("id") id: String
    ): Response<Unit>

}