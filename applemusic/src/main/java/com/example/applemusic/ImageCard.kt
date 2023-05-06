package com.example.applemusic.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.applemusic.R
import com.example.applemusic.ui.theme.Shapes
import com.example.applemusic.widget.CustomIconButton

@Composable
fun ImageCard(time: String, title: String, description: String) {
    Card(shape = Shapes.medium) {
        Column() {
            Image(
                painter = rememberAsyncImagePainter(model = "https://picsum.photos/seed/picsum/1200/800"),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier
                    .padding(8.dp)
                    .weight(0.85f)) {
                    Text(text = time)
                    Text(text = title)
                    Text(text = description)
                }
                Box(modifier = Modifier.weight(0.15f).align(Alignment.CenterVertically)) {
                    CustomIconButton(
                        icon = painterResource(id = R.drawable.baseline_play_arrow_24),
                        color = Color.Gray,
                        modifier = Modifier
                    )
                }

            }

        }
    }
}