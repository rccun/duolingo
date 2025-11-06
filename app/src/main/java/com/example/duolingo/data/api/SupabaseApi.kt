package com.example.duolingo.data.api

import com.example.duolingo.data.dto.ProfileModelDto
import com.example.duolingo.data.dto.SignUpDto
import com.example.duolingo.data.dto.SupabaseFileDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SupabaseApi {

//    @POST("auth/v1/token")
//    suspend fun signIn(@Body request: Sign): Response<AuthResponse>

//    @GET("auth/v1/user")
//    suspend fun getCurrentUser(): Response<Profil>
    @Headers("Cache-Control: no-cache")
    @POST("auth/v1/signup")
    suspend fun signUp(
        @Body request: SignUpDto
    ): Response<ProfileModelDto>

    @GET("storage/v1/object/public/{bucket}")
    suspend fun getAnimals(
        @Path("bucket") bucket: String,
        @Query("prefix") prefix: String = "",
        @Query("limit") limit: Int = 100
    ): List<SupabaseFileDto>
}