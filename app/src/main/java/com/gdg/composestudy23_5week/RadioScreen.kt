package com.gdg.composestudy23_5week

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.ui.theme.KawaiBlue
import com.gdg.composestudy23_5week.ui.theme.KawaiRed

@Composable
fun RadioScreen(modifier: Modifier, onPositionYChange: (Float) -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Radio",
            modifier = Modifier
                .padding(top = 8.dp)
                .onPlaced {
                    onPositionYChange(it.positionInRoot().y)
                },
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
        )
        Divider(modifier = Modifier.padding(top = 8.dp))
        Spacer(modifier = Modifier.height(12.dp))

        repeat(5) {
            Item()
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun Item() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Apple Music 1",
                style = MaterialTheme.typography.h6.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = "The new music that matters.",
                style = MaterialTheme.typography.body1.copy(color = Color.Gray)
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.DateRange, contentDescription = "Calendar", tint = KawaiRed)
        }
    }

    Box(contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(id = R.drawable.img_the_quiett),
            contentDescription = "TheQuiett Album",
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .aspectRatio(1.1f),
            contentScale = ContentScale.FillBounds
        )

        Surface(
            modifier = Modifier,
            shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp),
            color = KawaiBlue,
            contentColor = Color.White
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Text(
                        text = "LIVE: 8-10PM",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Text(
                        text = "The Quiett Show",
                        style = MaterialTheme.typography.h6.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Music from Dok2, C-JAMM, BewhY, Changmo, and Layone.",
                        style = MaterialTheme.typography.body1
                    )
                }

                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 28.dp)) {
                    Surface(
                        shape = CircleShape,
                        color = Color.White,
                        contentColor = KawaiBlue
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}