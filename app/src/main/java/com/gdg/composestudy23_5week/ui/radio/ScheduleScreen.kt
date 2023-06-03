package com.gdg.composestudy23_5week.ui.radio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.data.RadioSchedule
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme
import com.gdg.composestudy23_5week.ui.theme.PinkRed

@Preview(showBackground = true)
@Composable
fun RadioSchedulePreview() {
    ComposeStudy235weekTheme {
        RadioScheduleScreen()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RadioScheduleScreen() {
    val scrollState = rememberScrollState()
    val radioList = listOf(
        RadioSchedule(
            image = R.drawable.img_radio1,
            time = "LIVE 1-4PM",
            radioTitle = "Charlie Sloth Rap Show",
            radioDescription = "Stonebwoy brings Fire to the Booth."
        ),
        RadioSchedule(
            image = R.drawable.img_radio2,
            time = "4-6PM",
            radioTitle = "The Hits List",
            radioDescription = "Songs you know and love."
        ),
        RadioSchedule(
            image = R.drawable.img_radio3,
            time = "6-7PM",
            radioTitle = "Apple Music Country",
            radioDescription = "Where it sounds like home."
        ),
        RadioSchedule(
            image = R.drawable.img_radio2,
            time = "LIVE 7-9PM",
            radioTitle = "The Hits List",
            radioDescription = "Songs you know and love."
        ),
        RadioSchedule(
            image = R.drawable.img_radio1,
            time = "LIVE 9-11PM",
            radioTitle = "Charlie Sloth Rap Show",
            radioDescription = "Stonebwoy brings Fire to the Booth."
        ),
        RadioSchedule(
            image = R.drawable.img_radio3,
            time = "1-3AM",
            radioTitle = "Apple Music Country",
            radioDescription = "Where it sounds like home."
        ),
    )

    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true,
    )
    var showOriginScreen by remember { mutableStateOf(false) }

    if (showOriginScreen) {
        RadioScreen()
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
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        tint = PinkRed,
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                showOriginScreen = true
                            }
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    AnimatedVisibility(
                        visible = scrollState.value != 0, // 스크롤이 최상단이 아닐 때만 보여줌
                        enter = fadeIn() + expandVertically(TweenSpec(durationMillis = 300)),
                        exit = fadeOut() + shrinkVertically(TweenSpec(durationMillis = 300)),
                    ) {
                        Text(
                            text = "Apple Music Hits",
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .sizeIn(maxHeight = 30.dp, minHeight = 15.dp)
                        )
                    }

                }

                Column(
                    Modifier
                        .verticalScroll(state = scrollState)
                ) {

                    //SubscribeBtn()
                    //Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Apple Music Hits",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black,
                        modifier = Modifier.sizeIn(maxHeight = 50.dp, minHeight = 15.dp)
                    )

                    Divider(modifier = Modifier.padding(vertical = 10.dp))
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Schedule",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black,
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    RadioScheduleColumn(radioList, coroutineScope, modalSheetState)
                }
            }
        }
    }
}