package com.example.applemusic.widget.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.applemusic.R
import com.example.applemusic.ui.theme.DescriptionColor

@Composable
fun RadioCard(
    title: String,
    subTitle: String,
    time: String,
    imageTitle: String,
    imageDescription: String,
    bottomSheetImage: Painter,
    moveScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = title,
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = subTitle,
                    color = DescriptionColor
                )
            }

            CustomIconButton(
                icon = painterResource(id = R.drawable.baseline_calendar_month_24),
                color = Color.Red,
                modifier = Modifier.clickable { moveScreen() }
            )
        }

        MainImageCard(
            time = time,
            title = imageTitle,
            description = imageDescription,
            bottomSheetTitle = title,
            bottomSheetImage = bottomSheetImage
        )
    }
}