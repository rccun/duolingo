package com.example.duolingo.data.utils

import android.util.Log
import com.example.duolingo.domain.usecase.CustomResult

class CustomException() {
    operator fun invoke(
        message: String
    ): CustomResult<Nothing>  {
        Log.e("TAG_EXC", message)
        return CustomResult.Error(message)
    }
}