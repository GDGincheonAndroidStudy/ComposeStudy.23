package com.gdg.composestudy23_5week.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R

@Composable
fun CommercialTopBox() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xCC7431F1),
                        Color(0xCC077DE4)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 7.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.apple_logo),
                    contentDescription = "apple",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "Music",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Text(
                text = "Try it Now",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}

@Composable
fun CommercialContainer() {
    Surface(
        modifier = Modifier.fillMaxWidth().aspectRatio(1f),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.apple_music),
                contentDescription = "Commercial",
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Apple Music 6개월 무료 이용",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                )
                Text(text = "1억 곡의 음악을 광고 없이 즐기세요. 6개월 무료 이용 후\n월 8,900원의 요금이 청구됩니다.", style = TextStyle(fontSize = 12.sp), textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 5.dp))
                Box(
                    modifier = Modifier.clip(RoundedCornerShape(5.dp)).background(
                        Color(
                            0xFF,
                            0x1A,
                            0x4F,
                            0xFF
                        )
                    ).padding(horizontal = 50.dp, vertical = 7.dp)
                ) {
                    Text("무료 체험하기", style = TextStyle(color = Color.White))
                }
            }
        }
    }
}