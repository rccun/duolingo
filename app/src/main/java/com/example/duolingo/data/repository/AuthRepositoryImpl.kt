package com.example.duolingo.data.repository

import android.util.Log
import com.example.duolingo.data.data_source.InitSupabaseClient.client
import com.example.duolingo.domain.repository.AuthRepository
import com.example.duolingo.domain.usecase.Queue.ValidationResult
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest

class AuthRepositoryImpl : AuthRepository {
    override suspend fun signIn(
        email: String,
        password: String
    ): ValidationResult {
        try {
            client.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            return ValidationResult(true)
        } catch (e: Exception) {
            Log.d("TAG", e.message.toString() + " SignIn")
            return ValidationResult(false, "Не удалось авторизоваться")
        }
    }

    override suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): ValidationResult {
        try {
            /*
//            val result = client.auth.signUpWith(Email) {
//                this.email = email
//                this.password = password
//            }
//            when (result) {
//                is AuthResult.Session -> {
//                    val user = result.user.toDomain()
//                    AuthResult.Success(user)
//                }
//                is AuthResult.NeedConfirmation -> {
//                    AuthResult.Error("Подтвердите email")
//                }
//                else -> {
//                    AuthResult.Error("Ошибка регистрации")
//                }
//            }
//        } catch (e: Exception) {
//            AuthResult.Error("Ошибка сети: ${e.message}")
//        } */

            client.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }?.let { user ->
                client.postgrest["profiles"].insert(
                    mapOf(
                        "id" to user.id,
                        "name" to firstName,
                        "email" to email,
                        "password" to password
                    )
                )
            }
            return ValidationResult(true)
        } catch (e: Exception) {
            Log.e("TAG_FAILURE", e.message.toString())
            return ValidationResult(false, "Не удалось зарегистрироваться: " + e.message)
        }
    }
}