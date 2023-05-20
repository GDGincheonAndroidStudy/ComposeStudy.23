package com.gdg.composestudy23_5week.ui.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.data.Search
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme
import com.gdg.composestudy23_5week.ui.theme.PinkRed
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudy235weekTheme {
        SearchScreen()
    }
}

val resultList = listOf(
    Search(title = "I AM", artist = "IVE (아이브)"),
    Search(title = "UNFORGIVEN (feat. Nile Rodgers)", artist = "LE SSERAFIM (르세라핌)")
)

@Composable
fun SearchScreen() {
    val scrollState = rememberScrollState()
    var result by remember { mutableStateOf(false) }
    var textState by rememberSaveable { mutableStateOf("") }
    val searchQuery = remember { mutableStateOf("") }
    val searchResults = remember { mutableStateOf(emptyList<Search>()) }
    val onTextChange = { text: String ->
        textState = text
    }
    val categoryList = listOf(
        "Spatial Audio",
        "Apple Music Live",
        "Hip-Hop DNA",
        "Sing",
        "Charts",
        "K-Pop",
        "Pop",
        "Classical",
        "Jazz",
        "Hip-Hop",
        "R&B/Soul",
        "Alternative",
        "Rock",
        "Hits"
    )

    if (!result) {
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

            Text(
                text = "Search",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = textState,
                onValueChange = onTextChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
                    .clickable(onClick = { })
                    .onFocusChanged { if (it.isFocused) result = true },
                placeholder = { Text("Artists, Songs, Lyrics, and More", color = Color.Gray) },
                singleLine = true,
                maxLines = 1,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TryWindow()
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Browse Categories",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.Black
            )

            MusicListColumn(categoryList)
        }
    }
}





