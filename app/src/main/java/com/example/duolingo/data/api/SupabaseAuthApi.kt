package com.example.duolingo.data.api

import com.example.duolingo.data.dto.ProfileModelDto
import com.example.duolingo.data.dto.SignUpDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SupabaseAuthApi {

//    @POST("auth/v1/token")
//    suspend fun signIn(@Body request: Sign): Response<AuthResponse>

//    @GET("auth/v1/user")
//    suspend fun getCurrentUser(): Response<Profil>
    @Headers("Cache-Control: no-cache")
    @POST("auth/v1/signup")
    suspend fun signUp(
        @Body request: SignUpDto
    ): Response<ProfileModelDto>
}