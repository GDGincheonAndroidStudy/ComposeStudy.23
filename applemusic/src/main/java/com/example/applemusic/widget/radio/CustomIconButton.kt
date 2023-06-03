package com.example.applemusic.widget.radio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.applemusic.R

@Composable
fun CustomIconButton(icon: Painter, color: Color, modifier: Modifier = Modifier) {
    IconButton(onClick = { /*TODO*/ }, modifier = Modifier
        .clip(CircleShape)
        .background(
            color = colorResource(id = R.color.real_light_color)
        )
        .size(40.dp)) {
        Icon(
            painter = icon,
            contentDescription = "calender",
            tint = color,
            modifier = modifier.size(20.dp)
        )
    }
}