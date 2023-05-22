package com.gdg.composestudy23_5week.screen.setting

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.component.CustomScaffold
import com.gdg.composestudy23_5week.component.ThemeDialog
import com.gdg.composestudy23_5week.component.ThemeRadioButton

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingScreen(
    navigateToBack: () -> Unit
) {
    val scrollState = rememberScrollState()
    CustomScaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "설정") },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { navigateToBack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "back icon",
                            tint = Color.Red
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                SaveListRow()
                AudioRow()
                DisplayOptionRow()
            }
        }
    )
}

@Composable
fun SaveListRow() {
    val isChecked = remember { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = "보관함",
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Row {
            Column {
                Text(
                    text = "플레이리스트 노래 추가",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "노래를 플레이리스트에 추가하면 보관함에도 \n 추가됩니다.",
                    color = Color.Gray
                )
            }
            Switch(
                modifier = Modifier.padding(start = 40.dp),
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Red,
                    checkedTrackColor = Color.Red,
                    uncheckedThumbColor = Color.Gray,
                    uncheckedTrackColor = Color.Gray
                )
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Divider(
            color = Color.Gray,
        )
    }
}

@Composable
fun AudioRow() {
    val isChecked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = "오디오",
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier.padding(vertical = 12.dp)
        )
        Row {
            Column {
                Text(
                    text = "Directory Atoms",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "지원되는 노래를 Dolby Atmos로 재생합니다.",
                    color = Color.Gray
                )
            }
            Switch(
                modifier = Modifier.padding(start = 40.dp),
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Red,
                    checkedTrackColor = Color.Red,
                    uncheckedThumbColor = Color.Gray,
                    uncheckedTrackColor = Color.Gray
                )
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        Text(
            text = "오디오 음질",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        Text(
            text = "크로스페이드",
            fontWeight = FontWeight.Bold
        )
        Text(text = "자동", color = Color.Gray)
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        Text(
            text = "이퀼라이저",
            fontWeight = FontWeight.Bold
        )
        Text(text = "오디오 출력 설정을 조정합니다.", color = Color.Gray)
        Divider(
            modifier = Modifier.padding(vertical = 20.dp),
            color = Color.Gray,
        )
    }
}

@Composable
fun DisplayOptionRow() {
    val isChecked = remember { mutableStateOf(false) }
    var isOpenDialog = remember { mutableStateOf(false) }

    if (isOpenDialog.value) {
        ThemeDialog(isOpenDialog)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = "디스플레이 옵션",
            color = Color.Red,
            fontSize = 12.sp,
            // modifier = Modifier.padding(vertical = 12.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Box(modifier = Modifier.fillMaxWidth().clickable {
            isOpenDialog.value = true
        }) {
            Column {
                Text(
                    text = "테마",
                    fontWeight = FontWeight.Bold,
                )
                Text(text = "밝기", color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        Text(
            text = "모션",
            fontWeight = FontWeight.Bold
        )
        Text(text = "애니메이션이 표시되는 방식을 관리합니다.", color = Color.Gray)
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            text = "진단",
            color = Color.Red,
            fontSize = 12.sp,
            //modifier = Modifier.padding(vertical = 12.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "자동으로 보냄",
                fontWeight = FontWeight.Bold
            )
            Switch(
                modifier = Modifier.padding(start = 220.dp),
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Red,
                    checkedTrackColor = Color.Red,
                    uncheckedThumbColor = Color.Gray,
                    uncheckedTrackColor = Color.Gray
                )
            )
        }
        Text(
            text = "진단 및 개인정보 보호에 관하여",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        Divider(
            color = Color.Gray,
        )
    }
}

@Composable
fun ThemeDialog(
    isOpenDialog: MutableState<Boolean>
) {
    // var isOpenDialog = remember { mutableStateOf(true) }

    if (isOpenDialog.value) {
        AlertDialog(
            onDismissRequest = {
                isOpenDialog.value = false
            },
            title = {
                Text(text = "테마", fontWeight = FontWeight.Bold)
            },
            text = {
                ThemeRadioButton()
            },
            confirmButton = {
                Text(text = "취소", color = Color.Red, modifier = Modifier
                    .padding(end = 16.dp, bottom = 16.dp)
                    .clickable {
                        isOpenDialog.value = false
                    }
                )
            }
        )
    }
}


@Composable
@Preview
fun ComponentPreview() {
    DisplayOptionRow()
}

@Composable
@Preview
fun SettingScreenPreview() {

    SettingScreen(
        navigateToBack = { }
    )
}