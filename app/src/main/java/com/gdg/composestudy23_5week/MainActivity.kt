package com.gdg.composestudy23_5week

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.AppOpsManagerCompat
import com.gdg.composestudy23_5week.navigation.NavGraph
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudy235weekTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavGraph()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "라디오") },
                actions = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                }
            )
        }
    ) {
        ListScreen()
    }
}



@Composable
fun ListScreen() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            VideoItems("Apple Music1", "놓쳐서는 안 될 신곡")
            VideoItems("Apple Music Hits", "시대를 초월해 사랑받는 히트곡")
            VideoItems("Apple Music Country", "컨트리 팬들을 위한 보석 상자")

            ScrollingRowItems("최근 재생한 음악")
            ScrollingRowItems("새로운 에피소드")
            ScrollingRowItems("라디오 진행자")
            ScrollingRowItems("아티스트가 진행하는 라디오")
            ScrollingRowItems("새로운 프로그램 발견하기")
            ScrollingRowItems("아티스트 인터뷰")
            ScrollingRowItems("힙합/R&B 프로그램")
            ScrollingRowItems("Apple Music1")

            MusicGenreList()
        }
    }
}


@Composable
fun VideoItems(
    title: String,
    subTitle: String,
) {
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .weight(7f)
            ) {
                Text(text = title, fontSize = 20.sp, fontWeight = Bold)
                Text(text = subTitle, fontSize = 12.sp, color = Color.Gray)
            }
            Icon(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.LightGray, shape = CircleShape,),
                imageVector = Icons.Default.Email,
                contentDescription = null,

            )
        }
        Box(modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .height(160.dp)
        )
        Box(modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .height(80.dp)
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(7f),
                ) {
                    Text(
                        text = "실시간 오후 4시 ~ 7시",
                        color = Color.Gray
                    )
                    Text(
                        text = "The Apple Music 1 List",
                        color = Color.White
                    )
                    Text(
                        text = "Hear our current obessions and \n new discoveries making waves",
                        color = Color.Gray
                    )

                }
                Icon(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxSize()
                        .background(Color.White, shape = CircleShape,),
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = null
                )
            }
        }

    }

}

@Composable
fun ScrollingRowItems(title: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            fontSize = 20.sp,
            text = title,
            maxLines = 1,
            fontWeight = Bold
        )
        ScrollRow()
    }
}

@Composable
fun ScrollRow() {
    val itemList = (0..5).toList()
    val itemIndexedList = listOf("A","B","C")
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        /*items(itemList) {
            Text(text = "Item is $it")
        }
        item {
            Text(text = "Single item")
        }

        itemsIndexed(itemIndexedList) { index, item ->
            Text(text = "Item at index $index is $item")
        }*/
        item {
            PlaceholderCard("AAAAA")
            Spacer(modifier = Modifier.width(12.dp))
            PlaceholderCard("BBBBB")
            Spacer(modifier = Modifier.width(12.dp))
            PlaceholderCard("CCCCC")
            Spacer(modifier = Modifier.width(12.dp))
            PlaceholderCard("DDDDD")
            Spacer(modifier = Modifier.width(12.dp))
            PlaceholderCard("EEEEE")
            Spacer(modifier = Modifier.width(12.dp))
            PlaceholderCard("FFFFF")
            Spacer(modifier = Modifier.width(12.dp))
            PlaceholderCard("GGGGG")
        }
    }
}

@Composable
fun MainContent(
    placeholderItems: List<String>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = "text title"
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(items = placeholderItems) { itemMessage: String ->
                // PlaceholderCard()
            }
        }
    }
}

@Composable
fun PlaceholderCard(content: String) {
    Column {
        Box(modifier = Modifier
            .background(color = Color.Green)
            .size(100.dp, 100.dp)
        )
        Text(text = content)
    }
}

@Composable
fun MusicGenreList() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "더 알아보기", fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "팝", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "힙합/R&B", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "댄스", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "일렉트로닉",color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "싱어송라이터",color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "록", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "얼터너티브 & 인디 음악", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "메탈", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "재즈", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)

        Text(text = "클래식", color = Color.Red, fontSize = 20.sp,)
        Divider(thickness = 1.dp, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudy235weekTheme {
        //MainScreen()
        ListScreen()
    }
}