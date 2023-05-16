package com.example.applemusic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.applemusic.R
import com.example.applemusic.ui.theme.DescriptionColor
import com.example.applemusic.widget.CustomIconButton

@Composable
fun RadioCard(
    title: String,
    subTitle: String,
    time: String,
    imageTitle: String,
    imageDescription: String
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)) {
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
                modifier = Modifier
            )
        }

        ImageCard(time = time, title = imageTitle, description = imageDescription)
    }
}