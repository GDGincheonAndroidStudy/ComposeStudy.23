package com.example.applemusic.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.applemusic.widget.radio.PlayCircle

@Composable
fun RoundImage(musicImage: Painter, modifier: Modifier = Modifier) {
    Card(shape = MaterialTheme.shapes.medium) {
        Box(modifier = modifier.size(60.dp)) {
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