package com.example.foodcouriers.ui.UiText

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

sealed class UiText {

    data class DynamicString(val value: String) : UiText()
    data class StringRes(
       val id: Int
    ) : UiText()

    @Composable
    fun asString() : String {
        return when (this){
            is DynamicString -> value
            is StringRes -> LocalContext.current.getString(id)
        }
    }

    fun asString(context: Context) : String {
        return when (this){
            is DynamicString -> value
            is StringRes -> context.getString(id)
        }
    }
}