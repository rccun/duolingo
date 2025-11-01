package com.example.duolingo.data.api

import com.example.duolingo.data.dto.ProfileModelDto
import com.example.duolingo.data.dto.SignUpDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

// data/api/SupabaseApi.kt
interface SupabaseApi {

    // GET - получение всех пользователей
    @GET("users")
    suspend fun getUsers(
        @Query("select") select: String? = "*",
        @Query("limit") limit: Int? = null,
        @Query("order") order: String? = null
    ): Response<List<ProfileModelDto>>

    // GET - получение пользователя по ID
    @GET("users")
    suspend fun getUserById(
        @Query("id") id: String,
        @Query("select") select: String? = "*"
    ): Response<List<ProfileModelDto>>

    // POST - создание пользователя
    @POST("profiles")
    suspend fun createProfile(
        @Body request: ProfileModelDto
    ): Response<ProfileModelDto>

    // PATCH - обновление пользователя
    @PATCH("profiles")
    suspend fun updateProfile(
        @Query("id") id: String,
        @Body data: Map<String, Any>
    ): Response<List<ProfileModelDto>>

    // DELETE - удаление пользователя
    @DELETE("profiles")
    suspend fun deleteProfile(
        @Query("id") id: String
    ): Response<Unit>

    @POST("auth/v1/signup")
    suspend fun signUp(
        @Body request: SignUpDto
    ): Response<ProfileModelDto>
}