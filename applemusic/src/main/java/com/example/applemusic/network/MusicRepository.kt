package com.example.applemusic.network

import com.example.applemusic.data.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MusicRepository {
    private val musicRetrofitImpl = RetrofitImpl.getRetrofitService()

    suspend fun getRepository(): Flow<ApiState> = flow {
        kotlin.runCatching {
           musicRetrofitImpl.getMusicList()
        }.onSuccess {response ->
            emit(ApiState.Success(response))
        }.onFailure { error ->
            error.message?.let { emit(ApiState.Error(it)) }

        }
    }
}