package com.example.duolingo.data.repository

import com.example.duolingo.data.api.SupabaseApi
import com.example.duolingo.data.api.SupabaseRestApi
import com.example.duolingo.data.utils.CustomException
import com.example.duolingo.domain.repository.GuessRepository
import com.example.duolingo.domain.usecase.CustomResult

class GuessRepositoryImpl(
    private val api: SupabaseApi
): GuessRepository {
    override suspend fun getAnimalUrl(): CustomResult<String> {
        return try {


            val listResponse = api.getAnimals(bucket = "animals")
            val list = listResponse

            val randomImg = list.random()

            val publicUrl =
                "https://cdkxhfvlaartfvdsrjlz.supabase.co/storage/v1/object/public/animals/${randomImg.name}"
            CustomResult.Success(publicUrl)
        } catch (e: Exception) {
            CustomException()(e.message.toString())
        }
    }
}