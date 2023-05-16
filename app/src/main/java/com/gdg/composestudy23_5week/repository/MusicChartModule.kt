package com.gdg.composestudy23_5week.repository

import android.util.Log
import com.gdg.composestudy23_5week.data.Load
import com.gdg.composestudy23_5week.data.Music
import com.gdg.composestudy23_5week.network.KtorClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class MusicChartModule {
    val URL: String = "https://haeyum.dev/music/api/genieChart"

    suspend fun getMusicList(): Load {
        return kotlin.runCatching {
            val response = KtorClient.client.get<String>(URL) {
                headers {
                    append(HttpHeaders.Accept, "application/x-httpd-php")
                }
            }
            Log.d("result", response.toString())
            val data = Json.decodeFromString<List<Music>>(response)
            data
        }
            .getOrNull()?.let {
                Load.Success(it)
            } ?: Load.Fail("fail")
    }
}
