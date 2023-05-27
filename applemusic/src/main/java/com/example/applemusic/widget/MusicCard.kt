package com.example.applemusic.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.applemusic.data.MusicChart

@Composable
fun MusicCard(musicChart: MusicChart) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // card shape 주기
        Card(
            modifier = Modifier.size(50.dp), shape = MaterialTheme.shapes.medium
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = musicChart.thumbnail),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = musicChart.title)
            Text(text = "노래 ․ ${musicChart.artist[0]}")
        }
    }
    Divider(thickness = 1.dp)

}

@Composable
@Preview(showBackground = true)
fun PreviewFun() {
    MusicCard(
        musicChart = MusicChart(
            artist = listOf("지코"),
            title = "사랑이라 믿었던 것들은",
            thumbnail = "https://cdnimg.melon.co.kr/cm2/album/images/112/40/232/11240232_20230509151820_500.jpg"
        )
    )
}