package com.example.duolingo.data.repository

import com.example.duolingo.data.api.SupabaseAuthApi
import com.example.duolingo.data.api.SupabaseRestApi
import com.example.duolingo.data.dto.ProfileModelDto
import com.example.duolingo.data.dto.SignUpDto
import com.example.duolingo.data.dto.toDomain
import com.example.duolingo.data.utils.CustomException
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.AuthRepository
import com.example.duolingo.domain.usecase.CustomResult
import com.example.duolingo.domain.usecase.requireValue

class AuthRepositoryImpl(
    private val restApi: SupabaseRestApi,
    private val authApi: SupabaseAuthApi,
) : AuthRepository {
    override suspend fun signIn(
        email: String,
        password: String
    ): CustomResult<ProfileModel> {
        val her: ProfileModel = ProfileModel("", "", "", "", "", "", 0)
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
            val profile = ProfileModelDto(
                id = userAuth.id,
                email = email,
                password = password,
                firstName = firstName,
                lastName = lastName
            )


            val profileResult = restApi.createProfile(profile)

            if (profileResult.isSuccessful) {
                return CustomResult.Success(profile.toDomain())
            } else {
                val errorBody = profileResult.errorBody()?.string()
                return CustomException()("Registration failed: ${profileResult.code()} - $errorBody")
            }
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


//            Log.d("SIGNUP_DEBUG", "SignUp Response: ${response.code()}")
//            if (response.isSuccessful) {
//                val authResponse = response.body()
//                Log.d("SIGNUP_DEBUG", "User created: ${authResponse?.email}")
//                Log.d("SIGNUP_DEBUG", "Session: ${authResponse?.password}")
//            } else {
//                val errorBody = response.errorBody()?.string()
//                Log.e("SIGNUP_DEBUG", "SignUp failed: $errorBody")
//            }
            val response = authApi.signUp(request)
            if (response.isSuccessful) {
                val authResponse = response.body()

                if (authResponse != null) {
                    CustomResult.Success(authResponse)
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