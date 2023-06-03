package com.gdg.composestudy23_5week.screen.radio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.component.CustomScaffold
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RadioScreen(
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberScaffoldState()

    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetContent = {
            /*Button(onClick = { coroutineScope.launch { modalSheetState.hide() } }) {
                Text(text = "숨기기")
            }*/
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                Row {
                    Icon(
                        modifier = modifier
                            .wrapContentSize()
                            .padding(20.dp),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = ""
                    )
                    Text(
                        modifier = modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 15.dp),
                        text = "Apple Music Hits",
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(
                    modifier = modifier.fillMaxWidth(),
                    color = Color.LightGray,
                    thickness = 0.5.dp
                )
                Row(
                    modifier = modifier.padding(12.dp).fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "share icon",
                        tint = Color.Red
                    )
                    Text(text = "Share Station")
                }
            }
        }) {


        CustomScaffold(
            modifier = modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = { Text(text = "") },
                    backgroundColor = Color.White,
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.baseline_more_vert_24,
                                ),
                                contentDescription = null,
                                tint = Color.Red
                            )
                        }
                    }
                )
            },
            content = {
                Column(
                    modifier = modifier.fillMaxSize()
                ) {
                    RadioCardItem(
                        title = "Apple Music 1",
                        subTitle = "놓쳐서 안 될 신곡",
                        albumImage = R.drawable.img_new_jeans,
                        onClickCalendar = {
                            coroutineScope.launch {
                                if (modalSheetState.isVisible) modalSheetState.hide()
                                else modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                            }
                        }
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    RadioCardItem(
                        title = "Apple Music Hits",
                        subTitle = "시대를 초월해 사랑받는 히트곡",
                        albumImage = R.drawable.img_bts,
                        onClickCalendar = {
                            coroutineScope.launch {
                                if (modalSheetState.isVisible) modalSheetState.hide()
                                else modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                            }
                        }
                    )
                }
            }
        )
    }
}

@Composable
fun RadioCardItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    albumImage: Int,
    onClickCalendar: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 15.dp
            )
    ) {
        Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                    )
                Text(
                    text = subTitle,
                    color = Color.Gray,
                    fontSize = 15.sp
                )
            }
            IconButton(onClick = { onClickCalendar() }) {
                Icon(painter = painterResource(
                    id = R.drawable.baseline_calendar_month_24),
                    contentDescription = "calendar icon",
                    tint = Color.Red,
                    modifier = modifier
                        .background(
                            color = Color.LightGray, shape = CircleShape
                        )
                        .padding(6.dp)
                    )
            }
        }
        Image(
            modifier = modifier.size(1200.dp, 350.dp),
            painter = painterResource(
            id = albumImage),
            contentDescription = "album"
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            backgroundColor = Color.Gray,
            shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = modifier
                        .padding(start = 10.dp)
                        .weight(0.8f, true)
                ) {
                    Text(text = "실시간 오후 4시 ~ 6시", color = Color.LightGray)
                    Text(
                        text = "The Apple Music 1 List",
                        color = Color.White
                    )
                    Text(
                        text = "Hear our current obsessions and \n new discoveries making waves.",
                        color = Color.LightGray
                        )
                }
                Icon(
                    painter = painterResource(
                    id = R.drawable.baseline_calendar_month_24),
                    contentDescription = "calendar icon",
                    tint = Color.Red,
                    modifier = modifier
                        .padding(end = 15.dp)
                        .wrapContentSize()
                        .background(
                            color = Color.LightGray, shape = CircleShape
                        )
                        .padding(6.dp)
                        .weight(0.2f, true)
                        .align(Alignment.CenterVertically),
                )
            }
        }
    }
}

@Preview
@Composable
fun RadioCardItemPreview() {
    RadioCardItem(
        title = "Apple Music 1",
        subTitle = "놓쳐서 안 될 신곡",
        albumImage = R.drawable.img_new_jeans,
        onClickCalendar = {}
    )
}

@Preview
@Composable
fun RadioScreenPreview() {
    RadioScreen()
}