package com.gdg.composestudy23_5week.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.ui.theme.PinkRed

@Composable
fun TryWindow() {
    Card(
        modifier = Modifier
            .height(330.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.img_try),
                contentDescription = "radio image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(10.dp)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Explore 100 million songs.\nAll ad-free.",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Plus your entire music library on all your devices.\nPlan auto-renews for ₩8,900/month",
                    color = Color.Black,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(modifier = Modifier
                    .background(color = PinkRed, shape = RoundedCornerShape(5.dp))
                    .padding(horizontal = 50.dp, vertical = 5.dp)
                ){
                    Text(
                        text = "Try it Now",
                        color = Color.White,
                        fontSize = 18.sp,
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}