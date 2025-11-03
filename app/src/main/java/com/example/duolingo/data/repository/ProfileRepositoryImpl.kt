package com.example.duolingo.data.repository

import com.example.duolingo.data.api.SupabaseRestApi
import com.example.duolingo.data.dto.toDomain
import com.example.duolingo.data.utils.CustomException
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.ProfileRepository
import com.example.duolingo.domain.usecase.CustomResult
import kotlinx.coroutines.flow.channelFlow

class ProfileRepositoryImpl(
    private val api: SupabaseRestApi
) : ProfileRepository {
    override suspend fun getProfileFlow() = channelFlow<CustomResult<ProfileModel>> {

    }

    override suspend fun getProfileById(id: String): CustomResult<ProfileModel> {
        return try {
            val response = api.getProfileById(id = "eq.{$id}")

            if (response.isSuccessful) {
                val profileDto = response.body()?.firstOrNull()
                if (profileDto != null) {
                    CustomResult.Success(profileDto.toDomain())
                } else {
                    CustomException()("User not found")
                    //CustomResult.Error("User not found")
                }
            } else {
                CustomException()("HTTP error: ${response.code()}")
//                CustomResult.Error()
            }
        } catch (e: Exception) {
            CustomException()("Network error: ${e.message}")
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