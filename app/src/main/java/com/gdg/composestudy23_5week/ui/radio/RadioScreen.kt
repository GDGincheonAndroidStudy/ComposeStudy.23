package com.gdg.composestudy23_5week.ui.radio

import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.data.Radio
import com.gdg.composestudy23_5week.data.Station
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme
import com.gdg.composestudy23_5week.ui.theme.PinkRed

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudy235weekTheme {
        RadioScreen()
    }
}

@Composable
fun RadioScreen() {
    val scrollState = rememberScrollState()

    val radioList = listOf(
        Radio(title = "Apple Music 1", description = "The new music that matters.", image = R.drawable.img_radio1, time = "LIVE · 04:00 - 06:00", radioTitle = "Charlie Sloth Rap Show", radioDescription = "Stonebwoy brings Fire to the Booth." ),
        Radio(title = "Apple Music Hits", description = "Songs you know and love.", image = R.drawable.img_radio2, time = "LIVE · 04:00 - 06:00", radioTitle = "The Hits List", radioDescription = "Songs you know and love." ),
        Radio(title = "Apple Music Country", description = "Where it sounds like home.", image = R.drawable.img_radio3, time = "LIVE · 04:00 - 06:00", radioTitle = "Apple Music Country", radioDescription = "Where it sounds like home." )
    )
    val stationList = listOf(
        Station(title = "K-Pop Station", description = "Apple Music K-Pop", image = R.drawable.img_genre1),
        Station(title = "Halloween Party Station", description = "Apple Music Holiday", image = R.drawable.img_genre2),
        Station(title = "Hits Station", description = "Apple Music hits", image = R.drawable.img_genre3)
    )
    val exploreList = listOf("Pop", "Hip-Hop/R&B", "Dance", "Electronic", "Singer/Songwriter", "Rock", "Alternative &India", "Metal", "Jazz", "Classical", "Country", "Kids & Family", "Latin", "From Around the World", "Christian")

    Column(
        Modifier
            .padding(horizontal = 15.dp)
            .verticalScroll(state = scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "more",
                tint = PinkRed,
                modifier = Modifier.size(25.dp)
            )
        }

        SubscribeBtn()
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Radio",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        )

        Divider(modifier = Modifier.padding(vertical = 10.dp))

        RadioListColumn(radioList)
        Spacer(modifier = Modifier.height(30.dp))

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
                contentDescription = "arrow",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }

        MusicListRow(stationList)
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "More to Explore",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )

        exploreList.forEach {
            Divider(modifier = Modifier.padding(vertical = 10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = it,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = PinkRed
                )
                Icon(
                    imageVector = Icons.Rounded.ArrowForwardIos,
                    contentDescription = "arrow",
                    tint = Color.LightGray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}