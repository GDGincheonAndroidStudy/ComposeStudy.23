package com.gdg.composestudy23_5week.ui.radio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.data.Radio
import com.gdg.composestudy23_5week.data.Station
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme
import com.gdg.composestudy23_5week.ui.theme.PinkRed
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudy235weekTheme {
        RadioScreen()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RadioScreen() {
    val scrollState = rememberScrollState()
    val radioList = listOf(
        Radio(
            title = "Apple Music 1",
            description = "The new music that matters.",
            image = R.drawable.img_radio1,
            time = "LIVE · 04:00 - 06:00",
            radioTitle = "Charlie Sloth Rap Show",
            radioDescription = "Stonebwoy brings Fire to the Booth."
        ),
        Radio(
            title = "Apple Music Hits",
            description = "Songs you know and love.",
            image = R.drawable.img_radio2,
            time = "LIVE · 04:00 - 06:00",
            radioTitle = "The Hits List",
            radioDescription = "Songs you know and love."
        ),
        Radio(
            title = "Apple Music Country",
            description = "Where it sounds like home.",
            image = R.drawable.img_radio3,
            time = "LIVE · 04:00 - 06:00",
            radioTitle = "Apple Music Country",
            radioDescription = "Where it sounds like home."
        )
    )
    val stationList = listOf(
        Station(
            title = "K-Pop Station",
            description = "Apple Music K-Pop",
            image = R.drawable.img_genre1
        ),
        Station(
            title = "Halloween Party Station",
            description = "Apple Music Holiday",
            image = R.drawable.img_genre2
        ),
        Station(
            title = "Hits Station",
            description = "Apple Music hits",
            image = R.drawable.img_genre3
        )
    )
    val exploreList = listOf(
        "Pop",
        "Hip-Hop/R&B",
        "Dance",
        "Electronic",
        "Singer/Songwriter",
        "Rock",
        "Alternative &India",
        "Metal",
        "Jazz",
        "Classical",
        "Country",
        "Kids & Family",
        "Latin",
        "From Around the World",
        "Christian"
    )

    var showNewScreen by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        // set confirmStateChange = { false } user will not be able to dismiss bottom sheet by dragging or tapping outside.
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true,
    )

    if (showNewScreen) {
        RadioScheduleScreen()
    } else {
        ModalBottomSheetLayout(
            sheetContent = { ModalBottomSheet() },
            sheetState = modalSheetState
        ) {

            Column(
                Modifier
                    .padding(horizontal = 15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        AnimatedVisibility(
                            visible = scrollState.value != 0, // 스크롤이 최상단이 아닐 때만 보여줌
                            enter = fadeIn() + expandVertically(TweenSpec(durationMillis = 300)),
                            exit = fadeOut() + shrinkVertically(TweenSpec(durationMillis = 300)),
                        ) {
                            Text(
                                text = "Radio",
                                fontSize = 20.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .sizeIn(maxHeight = 30.dp, minHeight = 15.dp)
                            )
                        }
                    }
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "more",
                        tint = PinkRed,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }

                Column(
                    Modifier
                        .verticalScroll(state = scrollState)
                ) {

                    //SubscribeBtn()
                    //Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Radio",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black,
                        modifier = Modifier.sizeIn(maxHeight = 50.dp, minHeight = 15.dp)
                    )

                    Divider(modifier = Modifier.padding(vertical = 10.dp))

                    radioList.forEach {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 17.dp)
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = it.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                                Text(
                                    text = it.description,
                                    fontSize = 13.sp,
                                    color = Color.Gray,
                                    modifier = Modifier.padding(top = 3.dp)
                                )
                            }
                            Icon(
                                imageVector = Icons.Rounded.CalendarMonth,
                                contentDescription = "calender",
                                tint = PinkRed,
                                modifier = Modifier
                                    .background(
                                        shape = CircleShape,
                                        color = Color.Gray.copy(0.1f)
                                    )
                                    .padding(7.dp)
                                    .clickable {
                                        showNewScreen = true
                                    }
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 35.dp)
                                .clip(
                                    shape = RoundedCornerShape(15.dp)
                                ),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Image(
                                painter = painterResource(id = it.image),
                                contentDescription = "radio image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .pointerInput(Unit) {
                                        detectTapGestures(
                                            onLongPress = {
                                                coroutineScope.launch {
                                                    modalSheetState.show()
                                                }
                                            }
                                        )
                                    },
                                contentScale = ContentScale.Crop

                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color.Gray.copy(0.5f))
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = it.time,
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                    Text(
                                        text = it.radioTitle,
                                        color = Color.White,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 13.sp
                                    )
                                    Text(
                                        text = it.radioDescription,
                                        color = Color.White,
                                        fontSize = 13.sp,
                                        modifier = Modifier.padding(bottom = 5.dp)
                                    )
                                }
                                Icon(
                                    imageVector = Icons.Rounded.PlayCircle,
                                    contentDescription = "play",
                                    Modifier.size(45.dp),
                                    tint = Color.White
                                )
                            }
                        }
                    }

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
        }
    }
}