package com.gdg.composestudy23_5week.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircleFilled
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.data.MusicStation

@Composable
fun MusicBottomSheet(
    item: MusicStation

) {
    Column(modifier = Modifier.background(Color.White)) {
        Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.border(1.dp, Color.LightGray.copy(alpha = 0.7f), RoundedCornerShape(7.dp)).clip(RoundedCornerShape(7.dp)), contentAlignment = Alignment.Center) {
                Image(painter = painterResource(id = item.image), contentDescription = item.description, modifier = Modifier.size(100.dp))
                Icon(imageVector = Icons.Rounded.PlayCircleFilled, contentDescription = "play", modifier = Modifier.size(55.dp), tint = Color.White.copy(alpha = 0.7f))
            }
            Text(text = item.title, modifier = Modifier.padding(start = 20.dp), color = Color.Black, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W700))
        }
        Divider()
        Row(modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Rounded.Share, contentDescription = "", tint = Color.Red, modifier = Modifier.size(30.dp))
            Text(text = "스테이션 공유", modifier = Modifier.padding(start = 20.dp), color = Color.Black, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W600, letterSpacing = 0.6.sp))
        }
    }
}
