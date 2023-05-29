package com.example.applemusic.screen.setting

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applemusic.R

@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    var isDialog by remember {
        mutableStateOf(false)
    }
    if (isDialog) {
        Dialog() { isDialog = !isDialog }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(modifier = Modifier.padding(16.dp), text = "로그인")
        Divider(thickness = 1.dp)

        SubTitle(title = "디스플레이 옵션")
        SettingText(mainText = "테마", subText = "밝게") { isDialog = true }
        SettingText(mainText = "모션", subText = "애니메이션이 표시되는 방식을 관리합니다.") {}
        SubTitle(title = "진단")
        SwitchRow(text = "자동으로 보냄")
        Text(modifier = Modifier.padding(16.dp), text = "진단 및 개인정보 보호에 관하여")
        Divider(thickness = 1.dp)

        SubTitle(title = "차단")
        SettingText(mainText = "콘텐츠 차단", subText = "끔") {}
        Divider(thickness = 1.dp)

        SubTitle(title = "정보")
        Text(modifier = Modifier.padding(16.dp), text = "Apple Music 및 개인정보 보호에 관하여")
        Text(modifier = Modifier.padding(16.dp), text = "Apple Music 이용약관")

    }
}

@Composable
fun SubTitle(title: String) {
    Text(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
        text = title,
        fontWeight = FontWeight.Black,
        color = MaterialTheme.colors.secondary
    )
}

@Composable
fun SettingText(mainText: String, subText: String, event: () -> Unit) {
    Button(modifier = Modifier.fillMaxWidth(), elevation = null, onClick = { event() }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = mainText, style = MaterialTheme.typography.body1)
            Text(text = subText, color = Color.LightGray)
        }
    }
}

@Composable
fun SwitchRow(text: String) {
    var isSwitch by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier, text = text)
        Switch(
            checked = isSwitch,
            onCheckedChange = { isSwitch = !isSwitch },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colors.secondary,
                checkedTrackColor = colorResource(id = R.color.pink)
            )
        )
    }
}

@Composable
fun Dialog(close: () -> Unit) {
    androidx.compose.ui.window.Dialog(onDismissRequest = { close() }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colors.primary
        ) {
            DialogContent()
        }
    }
}

@Composable
fun DialogContent() {
    val radioOptions = listOf("밝게", "어둡게", "시스템 기본")

    var selectedItem by remember {
        mutableStateOf(radioOptions[0])
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(modifier = Modifier.padding(start = 12.dp), text = "테마", style = MaterialTheme.typography.h4)
        radioOptions.forEach { label ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                RadioButton(selected = (selectedItem == label), onClick = { selectedItem = label })
                Text(text = label)
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun PreviewDialog() {
    Dialog({})
}