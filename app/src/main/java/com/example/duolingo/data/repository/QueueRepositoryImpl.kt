package com.example.duolingo.data.repository

import android.content.Context
import androidx.core.content.edit
import com.example.duolingo.domain.repository.QueueRepository

class QueueRepositoryImpl(
    private val context: Context
): QueueRepository {

    private val key = "SP_KEY"
    private val sp = context.getSharedPreferences(key, Context.MODE_PRIVATE)

    override suspend fun getQueue(): Int {
        return sp.getInt(key, 0)
    }

    override suspend fun setQueue(value: Int) {
        sp.edit { clear().putInt(key, value) }
    }
}