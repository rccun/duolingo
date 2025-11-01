package com.example.duolingo.data.repository

import com.example.duolingo.data.api.SupabaseApi
import com.example.duolingo.data.data_source.SupabaseHttpClient
import com.example.duolingo.data.dto.toDomain
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.ProfileRepository
import com.example.duolingo.domain.usecase.CustomResult
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.retryWhen
import kotlinx.io.IOException

class ProfileRepositoryImpl(
    private val api: SupabaseApi
) : ProfileRepository {
    override suspend fun getProfileFlow() = channelFlow<CustomResult<ProfileModel>> {

    }

    override suspend fun getProfileById(id: String): CustomResult<ProfileModel> {
        return try {
            val response = api.getUserById(id)

            if (response.isSuccessful) {
                val profileDto = response.body()?.firstOrNull()
                if (profileDto != null) {
                    CustomResult.Success(profileDto.toDomain())
                } else {
                    CustomResult.Error("User not found")
                }
            } else {
                CustomResult.Error("HTTP error: ${response.code()}")
            }
        } catch (e: Exception) {
            CustomResult.Error("Network error: ${e.message}")
        }
    }

//        val job = launch {
//            try {
//                profileDao.getProfileFlow().collect {
//                    send(CustomResult(true))
//                }
//            } catch (_: Exception) {
//                send(Result.Error(DataError.LocalError.DISK_FULL))
//            }
//        }

//        getId()?.let { id ->
//
//            val result = savePostgrestCall {
//                val api = client.postgrest[Constants.Tables.USERS_TABLE_NAME].select {
//                    filter {
//                        eq("userID", id)
//                    }
//                }.decodeSingleOrNull<ProfileModelDto>()
//                api?.let {
//                    send(Result.Success(api))
//
//                    profileDao.updateProfileData(api)
//                }
//                return@savePostgrestCall api
//            }
//            send(result)
//        }

//        awaitClose { job.cancel() }
//    }.retryWhen { cause, attempt ->
//        if (cause is IOException && attempt < 3) {
//            //emit(Result.Loading())
//            delay(3000 * (attempt + 1))
//            true
//        } else {
//            false
//        }
//    }
//    suspend fun getId(): String? {
////        val data = profileDao.getProfile()
////        if (data != null) return data.userID
//
//        val response = SupabaseHttpClient.api.getUserById()
//        client.auth.awaitInitialization()
//        val api = client.auth.currentUserOrNull()?.id
//        return api
//    }
}