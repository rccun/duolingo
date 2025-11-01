package com.example.duolingo.data.repository

import android.util.Log
import com.example.duolingo.data.api.SupabaseApi
import com.example.duolingo.data.dto.ProfileModelDto
import com.example.duolingo.data.dto.SignUpDto
import com.example.duolingo.data.dto.toDomain
import com.example.duolingo.data.utils.CustomException
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.AuthRepository
import com.example.duolingo.domain.usecase.CustomResult
import com.example.duolingo.domain.usecase.requireValue
import com.google.android.gms.games.gamessignin.AuthResponse

class AuthRepositoryImpl(
    private val api: SupabaseApi
) : AuthRepository {
    override suspend fun signIn(
        email: String,
        password: String
    ): CustomResult<ProfileModel> {
        val her: ProfileModel = ProfileModel("", "", "", "", "", "")
        return CustomResult.Success(her)
//        try {
//            client.auth.signInWith(Email) {
//                this.email = email
//                this.password = password
//            }
//            return CustomResult.Success()
//            return CustomResult(true)
//        } catch (e: Exception) {
//            Log.d("TAG", e.message.toString() + " SignIn")
//            return CustomResult(false, "Не удалось авторизоваться")
//        }
    }

    override suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): CustomResult<ProfileModel> {
        try {
            val authResult = signUpAuth(email, password)
            val userAuth = authResult.requireValue()
            val profileResult = api.createProfile(ProfileModelDto(
                id = userAuth.id,
                email = userAuth.email,
                password = userAuth.password,
                firstName = firstName,
                lastName = lastName,
                avatarUrl = "https://cdkxhfvlaartfvdsrjlz.supabase.co/storage/v1/object/public/avatars/placeholder.jpg"
            ))
/*
//            client.auth.signUpWith(Email) {
//                this.email = email
//                this.password = password
//            }?.let { user ->
//                client.postgrest["profiles"].insert(
//                    mapOf(
//                        "id" to user.id,
//                        "first_name" to firstName,
//                        "email" to email,
//                        "password" to password,
//                        "last_name" to lastName
//                    )
//                )
//            }

 */
            val profileDto = profileResult.body()
            return CustomResult.Success(profileDto!!.toDomain())
        } catch (e: Exception) {
            return CustomException()(e.message.toString())
        }
    }
    private suspend fun signUpAuth(
        email: String,
        password: String
    ): CustomResult<ProfileModelDto> {
        return try {
            val request = SignUpDto(
                email = email,
                password = password
            )

// Создаем Call объект чтобы получить Request
            val response = api.signUp(request)

            if (response.isSuccessful) {
                val authResponse = response.body()
                val userAuth = authResponse?.email
                val session = ""

                if (userAuth != null && session != "null") {
                    CustomResult.Success(authResponse) // UserAuthDto - non-null
                //saveAuthToken(session.accessToken)
                } else {
                    CustomResult.Error("Auth response is incomplete")
                }
            } else {
                val errorMessage = parseAuthError(response)
                CustomResult.Error(errorMessage, response.code())
            }
        } catch (e: Exception) {
            CustomResult.Error("Auth signup failed: ${e.message}")
        }
    }
    private fun parseAuthError(response: retrofit2.Response<*>): String {
        return try {
            when (response.code()) {
                400 -> "Invalid email or password"
                422 -> "User already exists"
                429 -> "Too many requests"
                else -> response.errorBody()?.string() ?: "Auth error ${response.code()}"
            }
        } catch (e: Exception) {
            "Auth error ${response.code()}"
        }
    }

    override suspend fun getCurrentUser(): ProfileModel {
        TODO("Not yet implemented")
    }
}