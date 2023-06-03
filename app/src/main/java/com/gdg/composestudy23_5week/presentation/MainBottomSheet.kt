package com.gdg.composestudy23_5week.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gdg.composestudy23_5week.data.ThemeManager
import com.gdg.composestudy23_5week.presentation.radio.Album
import com.gdg.composestudy23_5week.supports.noRippleClickable

@Composable
fun MainBottomSheet(sheetAlbum: Album?, onHideSheet: () -> Unit) {
    val sheetAlbum = sheetAlbum
        ?: return Box(
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable { }
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Something wrong... Try it later",
                style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.error),
                textAlign = TextAlign.Center
            )
        }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .noRippleClickable(onHideSheet)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .clip(RoundedCornerShape(12.dp))
                    .then(
                        if (ThemeManager.collectIsDarkColorPalette()) Modifier else Modifier.border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(12.dp)
                        )
                    )
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = sheetAlbum.imageId),
                    contentDescription = "Album image"
                )

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxSize(0.5f)
                        .background(color = Color.LightGray.copy(alpha = 0.75f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        modifier = Modifier.fillMaxSize(0.7f),
                        tint = Color.White,
                    )
                }
            }

            Text(
                text = sheetAlbum.section,
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            )
        }
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (ThemeManager.collectIsDarkColorPalette()) Modifier.clickable(
                        onClick = onHideSheet
                    ) else Modifier.noRippleClickable(onClick = onHideSheet)
                )
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share",
                tint = MaterialTheme.colors.primary
            )
            Text(
                text = "Share Station",
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}