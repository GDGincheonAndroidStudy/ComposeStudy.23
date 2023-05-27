package com.gdg.composestudy23_5week.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.composestudy23_5week.helper.ThemeManager
import com.gdg.composestudy23_5week.model.ThemeMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navigateUp: () -> Unit) {
    val viewModel: SettingsViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            Column {
                SmallTopAppBar(
                    title = { Text("설정") },
                    navigationIcon = {
                        IconButton(onClick = navigateUp) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "뒤로가기"
                            )
                        }
                    }
                )
                Divider(color = Color.LightGray)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            val themeMode by viewModel.themeMode.collectAsState()
            var visibleThemeDialog by remember {
                mutableStateOf(false)
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                var autoSend by rememberSaveable {
                    mutableStateOf(false)
                }

                Section(title = "디스플레이 옵션", modifier = Modifier.padding(top = 8.dp)) {
                    TextStatusItem(
                        text = "테마", status = themeMode.text,
                        onClick = {
                            visibleThemeDialog = true
                        }
                    )
                    TextStatusItem(
                        text = "모션",
                        status = "에니메이션이 표시되는 방식을 관리합니다.",
                        onClick = {}
                    )
                }
                Section(title = "차단") {
                    TextStatusItem(text = "콘텐츠 차단", status = "끔", onClick = {})
                }
                Section(title = "진단") {
                    TextSwitchItem(
                        text = "자동으로 보냄",
                        checked = autoSend,
                        onCheckedChange = { autoSend = it },
                    )
                    TextItem(text = "진단 및 개인정보 보호에 관하여", onClick = {})
                }
                Section(title = "정보") {
                    TextItem(text = "Apple Music 및 개인정보 보호에 관하여", onClick = { /*TODO*/ })
                    TextItem(text = "Apple Music 이용 약관", onClick = { /*TODO*/ })
                    TextItem(text = "승인서", onClick = { /*TODO*/ })
                    TextItem(text = "피드백 제공", onClick = { /*TODO*/ })
                    TextItem(text = "지원 받기", onClick = { /*TODO*/ })
                    TextStatusItem(text = "버전", status = "4.2.0 (1286)", onClick = { /*TODO*/ })
                }
                Text(
                    text = "Copyright © 2015-2023 Apple Inc. 모든 권리 보유.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                    textAlign = TextAlign.Center
                )
            }
            AnimatedVisibility(visible = visibleThemeDialog) {
                ThemeDialog(
                    themeMode = themeMode,
                    onDismissRequest = { visibleThemeDialog = false },
                    setTheme = viewModel::setTheme
                )
            }
        }
    }
}

@Composable
private fun Section(title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier.padding(vertical = 8.dp)) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            content()
            Divider(color = Color.LightGray, thickness = 0.5.dp)
        }
    }
}

@Composable
private fun ThemeDialog(
    themeMode: ThemeMode,
    onDismissRequest: () -> Unit,
    setTheme: (ThemeMode) -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        val changeTheme: (ThemeMode) -> Unit = { themeMode ->
            onDismissRequest()
            setTheme(themeMode)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
        ) {
            Text(
                text = "테마",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            Column(modifier = Modifier.padding(top = 8.dp)) {
                RadioItem(
                    text = "밝게", selected = themeMode == ThemeMode.LIGHT,
                    onClick = {
                        changeTheme(ThemeMode.LIGHT)
                    }
                )
                RadioItem(
                    text = "어둡게", selected = themeMode == ThemeMode.DARK,
                    onClick = {
                        changeTheme(ThemeMode.DARK)
                    }
                )
                RadioItem(
                    text = "시스템 기본",
                    selected = themeMode == ThemeMode.AUTO,
                    onClick = {
                        changeTheme(ThemeMode.AUTO)
                    }
                )
            }
            Text(
                text = "취소",
                modifier = Modifier.align(Alignment.End).clickable(onClick = onDismissRequest),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RadioItem(text: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier.offset(x = (-12).dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary
            )
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun Item(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(16.dp),
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(paddingValues)
    ) {
        content()
    }
}

@Composable
private fun TextItem(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Item(onClick = onClick, modifier = modifier) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
private fun TextStatusItem(
    text: String,
    status: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Item(onClick = onClick) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
        Text(text = status, style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray))
    }
}

@Composable
private fun TextSwitchItem(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Item(onClick = { onCheckedChange(!checked) }, paddingValues = PaddingValues(16.dp, 4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge
            )
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                    checkedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
//                    uncheckedThumbColor = Color.White,
//                    uncheckedTrackColor = Color.LightGray
                ),
            )
        }
    }
}