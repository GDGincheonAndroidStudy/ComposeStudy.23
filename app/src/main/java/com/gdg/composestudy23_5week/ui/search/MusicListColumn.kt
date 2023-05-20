package com.gdg.composestudy23_5week.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R


@Composable
fun MusicListColumn(categoryList: List<String>) {
    val categoryListHeight = categoryList.size / 2 * 160

    LazyVerticalGrid(
        contentPadding = PaddingValues(vertical = 10.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier.height(categoryListHeight.dp)
    ) {
        items(categoryList.size) { index ->
            MusicListItem(category = categoryList[index])
        }
    }
}

@Composable
fun MusicListItem(category: String) {
    Row() {
        Box(
            Modifier.fillMaxWidth().height(130.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img_category),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 5.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = category,
                modifier = Modifier.padding(all= 10.dp).align(Alignment.BottomStart),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }
}

