package com.gdg.composestudy23_5week.ui.radio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R


@Composable
fun SubscribeBtn() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF816BFD),
                        Color(0xFF349AFF)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.img_apple_logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
                Text(
                    text = "Music",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W500
                )
            }
            Text(
                text = "Try it Now",
                color = Color.White,
                fontSize = 18.sp,
            )
        }
    }
}
