package com.example.applemusic.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.applemusic.R

@Composable
fun CategoryMainImageCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(100.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Box(modifier = Modifier) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.butter_waffle),
                contentScale = ContentScale.Crop,
                contentDescription = "butterWaffle"
            )
            Text(
                text = "Apple Music Live",
                color = MaterialTheme.colors.primary,
                modifier = Modifier.align(
                    Alignment.BottomStart
                ).padding(8.dp)
            )
        }
    }
}