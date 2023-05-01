package com.gdg.composestudy23_5week

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MusicStation(
    val title: String,
    val description: String,
    val image: Int
)

data class RadioMusic(
    val time: String,
    val musicStation: MusicStation
)

@Composable
fun RadioScreen() {
    val scrollState = rememberScrollState()
    val exploreList = listOf("Pop", "Hip-Hop/R&B", "Dance", "Electronic", "Singer/Songwriter", "Rock", "Alternative &India", "Metal", "Jazz", "Classical", "Country", "Jids & Family", "Latin", "From Around the World", "Christian")
    val musicStationList = listOf(MusicStation(title = "K-Pop", description = "Chart-dominating hits keep the guys and ghost", image = R.drawable.img_box_4), MusicStation(title = "Halloween Party", description = "Keep the guys and ghost chart-dominating hits", image = R.drawable.img_box_5), MusicStation(title = "Pop", description = "Keep the guys and ghost chart-dominating hits", image = R.drawable.img_box_6))
    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(state = scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "menu",
                tint = Color.Red,
                modifier = Modifier.size(27.dp)
            )
        }
        CommercialBox()
        Spacer(modifier = Modifier.height(height = 30.dp))
        Text(
            text = "Radio",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = Color.Black
        )
        Divider(modifier = Modifier.padding(top = 10.dp, bottom = 15.dp))

        RadioMusicTitle(title = "Apple Music 1", description = "The new music thar matters")
        RadioMusicContainer(
            RadioMusic(
                time = "Live 12-2PM",
                MusicStation(
                    title = "The Apple Music 1 List",
                    description = "Hear out current obsessions and new discoveries making waves.",
                    image = R.drawable.img_box_1

                )
            )
        )
        RadioMusicTitle(title = "Apple Music Hits", description = "Songs you know and love")
        RadioMusicContainer(
            RadioMusic(
                time = "Live 1-4PM",
                MusicStation(
                    title = "Pure Throwback",
                    description = "An amped up time capsule from the turn of the 2000s.",
                    image = R.drawable.img_box_2
                )
            )
        )
        RadioMusicTitle(title = "Apple Music Country", description = "Songs you know and love")
        RadioMusicContainer(
            RadioMusic(
                time = "Live 1-2PM",
                MusicStation(
                    title = "Kelsea Ballerini Essentials",
                    description = "Explore the carrer-defining hits of music's biggest stars.",
                    image = R.drawable.img_box_3
                )
            )

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 15.dp)
        ) {
            Text(
                text = "Stations by Genre",
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
        MusicListRow(musicStationList)
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "More to Explore",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        exploreList.forEach {
            Divider(modifier = Modifier.padding(vertical = 13.dp), color = Color.Black.copy(0.1f))
            Text(
                text = it,
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                color = Color.Red.copy(0.9f)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun CommercialBox() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xCC7431F1),
                        Color(0xCC077DE4)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 7.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.apple_logo),
                    contentDescription = "apple",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "Music",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Text(
                text = "Try it Now",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.W400
            )
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
        Column() {
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
        Text(text = musicStation.title + " Station", modifier = Modifier.padding(top = 7.dp, bottom = 3.dp), fontSize = 16.sp, color = Color.Black)
        Text(text = musicStation.description, overflow = TextOverflow.Ellipsis, maxLines = 1, color = Color.Black.copy(0.5f), fontSize = 15.sp)
    }
}
