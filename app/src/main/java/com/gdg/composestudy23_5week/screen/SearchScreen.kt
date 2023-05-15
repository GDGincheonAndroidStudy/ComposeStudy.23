package com.gdg.composestudy23_5week.screen // ktlint-disable package-name

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.gdg.composestudy23_5week.component.CategoryGridView
import com.gdg.composestudy23_5week.component.CommercialContainer
import com.gdg.composestudy23_5week.component.ScreenHeader
import com.gdg.composestudy23_5week.data.Music
import com.gdg.composestudy23_5week.viewmodel.SearchViewModel

@Composable
fun SearchScreen() {
    val scrollState = rememberScrollState()
    var content by remember {
        mutableStateOf("")
    }
    var focus by remember { mutableStateOf(false) }
    val focusRequester = remember { mutableStateOf(FocusRequester()) }
    val focusManager = LocalFocusManager.current

    val viewModel = remember {
        SearchViewModel()
    }
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 50.dp)
            .verticalScroll(state = scrollState)
    ) {
        if (!focus) {
            ScreenHeader("Search")
            Spacer(modifier = Modifier.height(10.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                modifier = Modifier
                    .padding(vertical = 0.dp)
                    .height(50.dp)
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray.copy(0.2f))
                    .padding(vertical = 0.dp)
                    .focusRequester(focusRequester.value)
                    .onFocusChanged {
                        focus = it.isFocused
                    },
                value = content,
                onValueChange = { content = it },
                placeholder = { Text(text = "Artists, Song, Lyrics, and More") },
                textStyle = TextStyle(color = Color.Black, textDecoration = TextDecoration.None),

                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.LightGray.copy(0.2f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = Color.Red
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }

            )
            if (focus) {
                Text(
                    "취소",
                    modifier = Modifier
                        .clickable {
                            focus = false
                            focusManager.clearFocus()
                        }
                        .padding(start = 10.dp),
                    color = Color.Red,
                    fontSize = 17.sp
                )
            }
        }
        if (focus) {
            FocusBody(viewModel.searchedList.collectAsState())
        } else {
            UnFocusBody()
        }
    }

    LaunchedEffect(content) {
        viewModel.searchList(content)
    }
}

@Composable
fun FocusBody(recentList: State<List<Music>>) {
    Spacer(modifier = Modifier.height(20.dp))
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "Recent Searched",
            fontWeight = FontWeight.W500,
            fontSize = 17.sp
        )
        Text(
            text = "Clear",
            style = TextStyle(color = Color.Red, fontWeight = FontWeight.W500, fontSize = 17.sp)
        )
    }
    Divider(modifier = Modifier.padding(top = 10.dp, bottom = 15.dp))
    HistoryView(recentList.value)
}

@Composable
fun UnFocusBody() {
    Spacer(modifier = Modifier.height(20.dp))
    CommercialContainer()
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = "Browse Categories",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.Black
    )
    Spacer(modifier = Modifier.height(10.dp))
    CategoryGridView()
}

@Composable
fun HistoryView(list: List<Music>) {
    LazyColumn() {
        items(list) { item ->
            MusicItem(item)
        }
    }
}

@Composable
fun MusicItem(music: Music) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(music.thumbnail),
                contentDescription = "",
                modifier = Modifier.height(60.dp).aspectRatio(1f).clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                Text(music.title, fontSize = 17.sp, fontWeight = FontWeight.W500)
                Text(
                    text = music.artist.toString().replace("[", "").replace("]", ""),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Black.copy(
                        0.5f
                    )
                )
            }
        }
        Icon(
            imageVector = Icons.Filled.MoreHoriz,
            contentDescription = ""
        )
    }
}

@Composable
@Preview
fun SearchScreenPreview() {
    SearchScreen()
}
