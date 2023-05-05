package com.gdg.composestudy23_5week.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Header(title: String, subHeaderPositionY: Float) {
    val targetAlpha = remember(subHeaderPositionY) {
        ((160 - subHeaderPositionY) / 100).coerceIn(0f, 1f)
    }
    val targetPadding = maxOf(0.dp, (subHeaderPositionY - 100).dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .drawBehind {
                drawLine(
                    color = Color.DarkGray,
                    strokeWidth = 2f,
                    start = Offset(x = 0f, y = size.height),
                    end = Offset(x = size.width, y = size.height),
                    alpha = targetAlpha
                )
            }
            .background(Color.White)
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(top = targetPadding)
                .alpha(targetAlpha)
        )
        Menu()
    }
}

@Composable
private fun Menu() {
    IconButton(onClick = { /*TODO*/ }) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            repeat(3) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.primary)
                        .size(4.dp)
                )
            }
        }
    }
}