package com.example.applemusic.screen.radio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applemusic.widget.RoundImage
import com.example.applemusic.widget.radio.PlayCircle

@Composable
fun CalenderScreen(title: String, musicList: List<Painter>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = title,
                color = Color.Black,
                style = MaterialTheme.typography.h1
            )
        }
        item { Divider(thickness = 1.dp) }

        item {
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "Schedule",
                style = MaterialTheme.typography.h4
            )
        }
        items(musicList.size) {
            CalenderMusicCard(musicImage = musicList[it])
        }
    }
}

@Composable
fun CalenderMusicCard(musicImage: Painter) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RoundImage2(musicImage = musicImage, modifier = Modifier.padding(vertical = 8.dp))
        Box(
            modifier = Modifier
                .height(136.dp)
                .padding(start = 16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.TopStart),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "LIVE 1~4PM", fontSize = 10.sp)
                Text(text = "Pure Throwback")
                Text(text = "An amped-up time capsule from the turn of the 2000s", fontSize = 14.sp)
            }
            Divider(
                thickness = 1.dp, modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
        }
    }

}

@Composable
fun RoundImage2(musicImage: Painter, modifier: Modifier = Modifier) {
    Card(shape = MaterialTheme.shapes.medium, modifier = modifier) {
        Box(modifier = Modifier.size(120.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = musicImage,
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            PlayCircle(modifier = Modifier.align(alignment = Alignment.Center))
            Icon(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(0.4f),
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "play",
                tint = Color.White
            )

        }
    }
}