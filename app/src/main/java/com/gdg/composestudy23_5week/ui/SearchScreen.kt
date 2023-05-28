package com.gdg.composestudy23_5week.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.composestudy23_5week.R

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navigateToSearchDetail: () -> Unit, navigateToSettings: () -> Unit) {
    val viewModel: SearchViewModel = hiltViewModel()

    Scaffold(
        topBar = { AppleMusicCloneAppBar("검색", navigateToSettings) }
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
            item {
                SearchTitle("카테고리 둘러보기")
            }
            items(20) {
                MusicItemsRow()
            }
        }
    }
}

@Composable
fun DemoContainer(title: String, description: String, resId: Int) {
    Surface(
        modifier = Modifier.padding(horizontal = 16.dp),
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
                    .background(color = MaterialTheme.colorScheme.background)
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

@Composable
fun SearchTitle(title: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}

@Composable
fun MusicItemsRow() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MusicListItem("Test1")
        MusicListItem("Test2")
    }
}

@Composable
fun RowScope.MusicListItem(category: String) {
    Box(
        Modifier.weight(1f).height(130.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img_izone),
            contentDescription = "",
            modifier = Modifier
                .padding(all = 5.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = category,
            modifier = Modifier.padding(all= 10.dp).align(Alignment.BottomStart),
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            color = White
        )
    }
}