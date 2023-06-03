package com.example.applemusic.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applemusic.widget.radio.ButtonContent
import com.example.applemusic.R
import com.example.applemusic.data.RadioCardData
import com.example.applemusic.widget.radio.RadioCard
import com.example.applemusic.ui.theme.Shapes
import com.example.applemusic.widget.radio.StationCard
import com.example.applemusic.widget.Title

@Composable
fun RadioScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    val titleList = listOf(
        stringResource(id = R.string.radio_title1),
        stringResource(id = R.string.radio_title2),
        stringResource(id = R.string.radio_title3)
    )

    val radioCardList = listOf<RadioCardData>(
        RadioCardData(
            title = stringResource(id = R.string.radio_title1),
            subTitle = stringResource(id = R.string.radio_description1),
            time = stringResource(id = R.string.radio_time1),
            imageTitle = stringResource(id = R.string.radio_image_tile1),
            imageDescription = stringResource(id = R.string.radio_image_description1),
            bottomSheetImage = painterResource(id = R.drawable.bottom_sheet_music1),
            moveScreen = { navController.navigate("calenderScreen1/${titleList[0]}") }
        ),
        RadioCardData(
            title = stringResource(id = R.string.radio_title2),
            subTitle = stringResource(id = R.string.radio_description2),
            time = stringResource(id = R.string.radio_time2),
            imageTitle = stringResource(id = R.string.radio_image_tile2),
            imageDescription = stringResource(id = R.string.radio_image_description2),
            bottomSheetImage = painterResource(id = R.drawable.bottom_sheet_music2),
            moveScreen = { navController.navigate("calenderScreen2/${titleList[1]}") }
        ),
        RadioCardData(
            title = stringResource(id = R.string.radio_title3),
            subTitle = stringResource(id = R.string.radio_description3),
            time = stringResource(id = R.string.radio_time3),
            imageTitle = stringResource(id = R.string.radio_image_tile3),
            imageDescription = stringResource(id = R.string.radio_image_description3),
            bottomSheetImage = painterResource(id = R.drawable.bottom_sheet_music3),
            moveScreen = { navController.navigate("calenderScreen3/${titleList[2]}") }
        ),
    )

    val stationList = listOf(
        R.string.station_title1,
        R.string.station_title2,
        R.string.station_title3,
        R.string.station_title4,
        R.string.station_title5,
        R.string.station_title6,
        R.string.station_title7,
        R.string.station_title8,
        R.string.station_title9,
        R.string.station_title10,
        R.string.station_title11
    )

    val colorStops = arrayOf(
        0.0f to colorResource(id = R.color.purple_200),
        1f to Color.Blue
    )


    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            contentPadding = PaddingValues(),
            onClick = { /*TODO*/ },
            shape = Shapes.medium,
            border = BorderStroke(width = 0.dp, color = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.horizontalGradient(colorStops = colorStops))
            ) {
                ButtonContent()
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Title(title = stringResource(id = R.string.radio_title))
        Divider(thickness = 1.dp, modifier = Modifier.padding(top = 12.dp))

        radioCardList.forEach {
            RadioCard(
                title = it.title,
                subTitle = it.subTitle,
                time = it.time,
                imageTitle = it.imageTitle,
                imageDescription = it.imageDescription,
                bottomSheetImage = it.bottomSheetImage,
                moveScreen = it.moveScreen,
            )
        }



        Text(
            text = "장르별 스테이션 >",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding()
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(stationList) {
                StationCard(title = stringResource(id = it))
            }
        }

    }
}