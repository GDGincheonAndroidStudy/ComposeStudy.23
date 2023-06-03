package com.example.applemusic.widget.radio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.applemusic.R
import com.example.applemusic.ui.theme.Shapes

@Composable
fun StationCard(title: String = "제목") {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.loop_image),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.size(150.dp).clip(Shapes.medium)
        )
        Text(text = title, modifier = Modifier.padding(top = 8.dp))
    }
}