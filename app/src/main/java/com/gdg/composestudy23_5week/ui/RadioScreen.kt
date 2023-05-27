package com.gdg.composestudy23_5week.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material3.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.composestudy23_5week.model.ListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioScreen(navigateToSettings: () -> Unit) {
    val viewModel: RadioViewModel = hiltViewModel()

    Scaffold(topBar = { AppleMusicCloneAppBar("라디오", navigateToSettings) }) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            item {
                TitleHeader("라디오")
                Divider(
                    modifier = Modifier.padding(top = 8.dp).padding(horizontal = 16.dp),
                    color = Color.LightGray,
                    thickness = 0.5.dp
                )
            }
            items(viewModel.list) { item ->
                when (item) {
                    is ListItem.RadioMusic -> {
                        RadioMusicTitle(item.title, item.description)
                        RadioMusicContainer(item)
                    }
                    is ListItem.StationsByGenre -> {
                        MusicListRow(item)
                    }
                    is ListItem.More -> {
                        Divider(modifier = Modifier.padding(vertical = 13.dp).padding(start = 16.dp), color = Color.Black.copy(0.1f))
                        Text(
                            text = item.genre,
                            modifier = Modifier.padding(horizontal = 16.dp),
                            fontWeight = FontWeight.W400,
                            fontSize = 20.sp,
                            color = Color.Red.copy(0.9f)
                        )
                    }
                }
            }
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
            .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 17.dp)
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
fun RadioMusicContainer(radioMusic: ListItem.RadioMusic) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 35.dp)
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
fun MusicListRow(musicStation: ListItem.StationsByGenre) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 15.dp)
    ) {
        Text(
            text = "장르별 스테이션",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Icon(
            imageVector = Icons.Rounded.ArrowForwardIos,
            contentDescription = "",
            tint = Color.Black.copy(alpha = 0.7f),
            modifier = Modifier.size(20.dp)
        )
    }
    LazyRow {
        items(
            musicStation.stations.size
        ) { index ->
            MusicListItem(musicStation = musicStation.stations[index])
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun MusicListItem(musicStation: ListItem.MusicStation) {
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