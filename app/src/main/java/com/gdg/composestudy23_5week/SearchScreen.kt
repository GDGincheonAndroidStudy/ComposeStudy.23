package com.gdg.composestudy23_5week

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navigateToSearchDetail: () -> Unit) {
    val viewModel: SearchViewModel = hiltViewModel()

    Scaffold(
        topBar = { AppleMusicCloneAppBar("검색") }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ) {
            item {
                TitleHeader("검색")
            }
            stickyHeader {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(horizontal = 16.dp, vertical = 8.dp)) {
                    Text(
                        text = "아티스트, 노래, 가사 등",
                        modifier = Modifier.fillMaxWidth()
                            .background(LightGray, RoundedCornerShape(10.dp))
                            .padding(12.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = navigateToSearchDetail
                            ),
                        color = Gray,
                        fontSize = 18.sp
                    )
                }
            }
            item {
                DemoContainer(
                    "1개월 무료 체험하기",
                    "보유 중인 모든 기기에서 음악 보관함 전체를 즐길 수 있습니다. 1개월 무료 체험 후 \\8,900/개월의 요금이 청구됩니다.",
                    R.drawable.img_box_6
                )
            }
            items(40) {
                Text("Hello ${viewModel.text}")
            }
        }
    }
}

@Composable
fun DemoContainer(title: String, description: String, resId: Int) {
    Surface(
        modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 35.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = resId),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(15.dp))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = White)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Text(
                        text = description,
                        fontSize = 15.sp
                    )
                    Button(
                        onClick = {  },
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        Text("무료 체험", modifier = Modifier.padding(2.dp), fontSize = 14.sp, textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}