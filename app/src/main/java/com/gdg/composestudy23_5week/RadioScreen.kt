package com.gdg.composestudy23_5week

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RadioScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(40) {
            Text("Hello Radio")
        }
    }
}

@Composable
fun RadioMusicTitle(title: String, description: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 17.dp)
    ) {
        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = description,
                fontWeight = FontWeight.W300,
                fontSize = 15.sp,
                color = Color.Black.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 3.dp)
            )
        }
        Icon(
            imageVector = Icons.Rounded.CalendarMonth,
            contentDescription = "calender",
            tint = Color.Red,
            modifier = Modifier
                .background(
                    shape = CircleShape,
                    color = Color.Black.copy(alpha = 0.05f)
                )
                .padding(7.dp)
        )
    }
}

@Composable
fun RadioMusicContainer(radioMusic: RadioMusic) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 35.dp)
            .aspectRatio(1f)
            .clip(
                shape = RoundedCornerShape(15.dp)
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = radioMusic.musicStation.image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(15.dp))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent.copy(0.3f))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = radioMusic.time,
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 13.sp
                )
                Text(
                    text = radioMusic.musicStation.title,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = radioMusic.musicStation.description,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W400
                )
            }
            Icon(
                imageVector = Icons.Rounded.PlayCircle,
                contentDescription = "",
                Modifier.size(45.dp),
                tint = Color.White.copy(alpha = 0.9f)
            )
        }
    }
}

@Composable
fun MusicListRow(musicStation: List<MusicStation>) {
    LazyRow {
        items(
            musicStation.size
        ) { index ->
            MusicListItem(musicStation = musicStation[index])
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun MusicListItem(musicStation: MusicStation) {
    Column(Modifier.width(175.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = musicStation.image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp))
            )
        }
        Text(
            text = musicStation.title + " Station",
            modifier = Modifier.padding(top = 7.dp, bottom = 3.dp),
            fontSize = 16.sp,
            color = Color.Black
        )
        Text(
            text = musicStation.description,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            color = Color.Black.copy(0.5f),
            fontSize = 15.sp
        )
    }
}