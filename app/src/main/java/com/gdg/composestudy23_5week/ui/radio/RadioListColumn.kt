package com.gdg.composestudy23_5week

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.PlayCircle
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
import com.gdg.composestudy23_5week.ui.theme.PinkRed


@Composable
fun RadioListColumn(radioList: List<Radio>) {
    radioList.forEach {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 17.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = it.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = it.description,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 3.dp)
                )
            }
            Icon(
                imageVector = Icons.Rounded.CalendarMonth,
                contentDescription = "calender",
                tint = PinkRed,
                modifier = Modifier
                    .background(
                        shape = CircleShape,
                        color = Color.Gray.copy(0.1f)
                    )
                    .padding(7.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 35.dp)
                .clip(
                    shape = RoundedCornerShape(15.dp)
                ),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = it.image),
                contentDescription = "radio image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray.copy(0.5f))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = it.time,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Text(
                        text = it.radioTitle,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp
                    )
                    Text(
                        text = it.radioDescription,
                        color = Color.White,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }
                Icon(
                    imageVector = Icons.Rounded.PlayCircle,
                    contentDescription = "play",
                    Modifier.size(45.dp),
                    tint = Color.White
                )
            }
        }
    }
}
