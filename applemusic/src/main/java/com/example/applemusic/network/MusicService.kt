package com.example.applemusic.network

import com.example.applemusic.data.MusicChart
import retrofit2.http.*

interface MusicService {
    @GET("melonChart.php")
//    @Headers(
//        "accept: application/x-httpd-php",
//    )
    suspend fun getMusicList():List<MusicChart>
}
