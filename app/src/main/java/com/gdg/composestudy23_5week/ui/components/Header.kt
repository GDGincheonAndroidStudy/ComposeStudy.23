package com.gdg.composestudy23_5week.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    title: String,
    subHeaderPositionY: Float = 0f,
    visibleBack: Boolean = false,
    visibleSettings: Boolean = false,
    onClickBack: () -> Unit = {},
    onClickSettings: () -> Unit = {}
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val targetAlpha = remember(subHeaderPositionY) {
        ((160 - subHeaderPositionY) / 100).coerceIn(0f, 1f)
    }
    val targetPadding = remember(subHeaderPositionY) {
        maxOf(0.dp, (subHeaderPositionY - 100).dp)
    }

    Box(
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
            .background(MaterialTheme.colors.background)
    ) {
        if (visibleBack) {
            IconButton(onClick = onClickBack, modifier = Modifier.align(Alignment.CenterStart)) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colors.primary
                )
            }
        }

        Text(
            text = title,
            modifier = Modifier
                .then(if (visibleBack) Modifier.align(Alignment.Center) else Modifier.align(Alignment.CenterStart))
                .padding(top = targetPadding, start = 16.dp)
                .alpha(targetAlpha),
            style = MaterialTheme.typography.h6,
        )

        if (visibleSettings) {
            Box(
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Menu(onClickSettings = { expanded = true })
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    DropdownMenuItem(onClick = {
                        onClickSettings()
                        expanded = false
                    }) {
                        Text(text = "Settings")
                    }
                    DropdownMenuItem(onClick = { expanded = false }) {
                        Text(text = "Account")
                    }
                }
            }
        } else {
            Box(Modifier)
        }
    }
}

@Composable
private fun Menu(onClickSettings: () -> Unit) {
    IconButton(onClick = onClickSettings) {
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