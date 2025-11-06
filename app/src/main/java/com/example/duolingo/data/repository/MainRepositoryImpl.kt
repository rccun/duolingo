package com.example.duolingo.data.repository

import com.example.duolingo.data.api.SupabaseRestApi
import com.example.duolingo.data.dto.toDomain
import com.example.duolingo.data.utils.CustomException
import com.example.duolingo.domain.model.ExerciseModel
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.domain.repository.MainRepository
import com.example.duolingo.domain.usecase.CustomResult

class MainRepositoryImpl(
    private val restApi: SupabaseRestApi
) : MainRepository {
    override suspend fun getTopProfiles(): CustomResult<List<ProfileModel>> {
        return try {
            val response = restApi.getProfiles(order = "score.desc", limit = 3)
            val mutableList: MutableList<ProfileModel> = mutableListOf()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    body.forEach { i ->
                        mutableList.add(i.toDomain())
                    }
                    CustomResult.Success(mutableList)
                } else {
                    CustomException()("Users not found")
                }
            } else {
                CustomException()("HTTP error: ${response.code()}")
            }
        } catch (e: Exception) {
            CustomException()(e.message.toString())
        }
    }

    override suspend fun getExercises(): CustomResult<List<ExerciseModel>> {
        return try {
            val response = restApi.getExercises(order = "title.asc")
            val mutableList: MutableList<ExerciseModel> = mutableListOf()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    body.forEach { i ->
                        mutableList.add(i.toDomain())
                    }
                    CustomResult.Success(mutableList)
                } else {
                    CustomException()("Exercises not found")
                }
            } else {
                CustomException()("HTTP error: ${response.code()}")
            }
            //val l: List<ProfileModel> = emptyList()
            //CustomResult.Success(list)
        } catch (e: Exception) {
            CustomException()(e.message.toString())
        }
    }
}