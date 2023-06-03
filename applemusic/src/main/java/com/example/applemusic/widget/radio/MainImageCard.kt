package com.example.applemusic.widget.radio

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.applemusic.R
import com.example.applemusic.ui.theme.Shapes
import com.example.applemusic.widget.RoundImage
import com.holix.android.bottomsheetdialog.compose.BottomSheetDialog

@Composable
fun MainImageCard(
    time: String,
    title: String,
    description: String,
    bottomSheetTitle: String,
    bottomSheetImage: Painter
) {
    var isDialog by remember {
        mutableStateOf(false)
    }

    if (isDialog) {
        MyBottomSheetDialog(
            title = bottomSheetTitle,
            bottomSheetImage = bottomSheetImage
        ) { isDialog = !isDialog }
    }

    Card(modifier = Modifier.clickable { isDialog = true }, shape = Shapes.medium) {
        Column() {
            Image(
                painter = rememberAsyncImagePainter(model = "https://picsum.photos/seed/picsum/1200/930"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(0.85f)
                ) {
                    Text(text = time, fontSize = 10.sp)
                    Text(text = title, fontWeight = FontWeight.Bold)
                    Text(text = description, fontSize = 12.sp, fontWeight = FontWeight.Normal)
                }
                Box(
                    modifier = Modifier
                        .weight(0.15f)
                        .align(Alignment.CenterVertically)
                ) {
                    CustomIconButton(
                        icon = painterResource(id = R.drawable.baseline_play_arrow_24),
                        color = Color.Gray,
                        modifier = Modifier
                    )
                }

            }

        }
    }
}

@Composable
fun MyBottomSheetDialog(title: String, bottomSheetImage: Painter, close: () -> Unit) {
    BottomSheetDialog(onDismissRequest = { close() }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .wrapContentHeight(),
            color = MaterialTheme.colors.primary
        ) {
            BottomSheetDialogContent(title = title, bottomSheetImage = bottomSheetImage)
        }
    }
}

@Composable
fun BottomSheetDialogContent(title: String, bottomSheetImage: Painter) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(musicImage = bottomSheetImage)
            Text(
                modifier = Modifier.padding(16.dp),
                text = title,
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        }
        Divider(thickness = 1.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Share, contentDescription = "share", tint = Color.Red)
            Text(modifier = Modifier.padding(16.dp), text = "Share Station", fontSize = 16.sp)
        }
    }
}
@Composable
fun PlayCircle(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(30.dp)) {
        val centerX = size.width / 2
        val centerY = size.height / 2

        drawCircle(
            color = Color.LightGray,
            alpha = 0.3f,
            radius = 50f,
            center = Offset(centerX, centerY),
        )
    }
}

//@Composable
//@Preview(showBackground = true)
//fun PreviewCom() {
//    RoundImage()
//}