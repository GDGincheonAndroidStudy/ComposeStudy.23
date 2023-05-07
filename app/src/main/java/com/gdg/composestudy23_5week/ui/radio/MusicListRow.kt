package com.gdg.composestudy23_5week

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.ui.radio.Station


@Composable
fun MusicListRow(stationList: List<Station>) {
    LazyRow {
        items(stationList.size) { index ->
            MusicListItem(station = stationList[index])
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun MusicListItem(station: Station) {
    Column(Modifier.width(175.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = station.image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp))
            )
        }
        Text(text = station.title, modifier = Modifier.padding(top = 5.dp), fontWeight = FontWeight.SemiBold, fontSize = 15.sp, color = Color.Black)
        Text(text = station.description, overflow = TextOverflow.Ellipsis, maxLines = 1, color = Color.Gray, fontSize = 15.sp)
    }
}
