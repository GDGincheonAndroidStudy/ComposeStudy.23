package com.gdg.composestudy23_5week.repository

import com.gdg.composestudy23_5week.data.Load
import com.gdg.composestudy23_5week.data.Music
import com.gdg.composestudy23_5week.network.KtorClient
import io.ktor.client.request.get
class MusicChartModule {
    val URL: String = "https://haeyum.dev/music/api/genieChart"

    suspend fun getMusicList(): Load =
        kotlin.runCatching {
            KtorClient.client.get<ArrayList<Music>>(URL)
        }.getOrNull()?.let {
            Load.Success(it)
        } ?: Load.Fail("fail")
}
