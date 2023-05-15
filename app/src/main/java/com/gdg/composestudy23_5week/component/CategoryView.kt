package com.gdg.composestudy23_5week.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun CategoryGridView() {
    val titleList = listOf("Pop", "Hip-Hop/R&B", "Dance", "Electronic", "Singer/Songwriter", "Rock", "Alternative &India", "Jazz")
    val imageList = listOf(R.drawable.img_box_1, R.drawable.img_box_2, R.drawable.img_box_3, R.drawable.img_box_4, R.drawable.img_box_5, R.drawable.img_box_6, R.drawable.img_box_2, R.drawable.img_box_3)
    for (i in 0..7 step(2)) {
        Row() {
            CategoryItem(image = imageList[i], title = titleList[i])
            Spacer(modifier = Modifier.width(10.dp))
            CategoryItem(image = imageList[i + 1], title = titleList[i + 1])
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun RowScope.CategoryItem(image: Int, title: String) {
    Box(
        modifier =
        Modifier.clip(
            shape = RoundedCornerShape(10.dp)
        )
            .aspectRatio(1.5f)
            .weight(1f)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(10.dp)),

            contentScale = ContentScale.FillWidth
        )
        Text(text = title, modifier = Modifier.align(Alignment.BottomStart).padding(bottom = 10.dp, start = 10.dp), color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}
