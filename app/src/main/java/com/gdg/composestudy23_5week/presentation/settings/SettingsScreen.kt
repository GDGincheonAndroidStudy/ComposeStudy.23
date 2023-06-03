package com.gdg.composestudy23_5week.presentation.settings

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gdg.composestudy23_5week.data.ThemeManager
import com.gdg.composestudy23_5week.data.ThemeMode
import com.gdg.composestudy23_5week.ui.components.Header

@Composable
fun SettingsScreen(onClose: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        val themeMode by ThemeManager.themeMode.collectAsState()
        var visibleThemeDialog by remember {
            mutableStateOf(false)
        }

        Column {
            Header(title = "Settings", visibleBack = true, onClickBack = onClose)

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                var autoSend by rememberSaveable {
                    mutableStateOf(false)
                }

                Section(title = "Display Options", modifier = Modifier.padding(top = 8.dp)) {
                    TextStatusItem(
                        text = "Theme", status = themeMode.text,
                        onClick = {
                            visibleThemeDialog = true
                        }
                    )
                    TextStatusItem(
                        text = "Motion",
                        status = "Manage how animations are displayed.",
                        onClick = {}
                    )
                }

                Section(title = "Restrictions") {
                    TextStatusItem(text = "Content Restrictions", status = "Off", onClick = {})
                }

                Section(title = "Diagnostics") {
                    TextSwitchItem(
                        text = "Automatically Send",
                        checked = autoSend,
                        onCheckedChange = { autoSend = it },
                    )
                    TextItem(text = "About Diagnostics & Privacy", onClick = {})
                }

                Section(title = "About") {
                    TextItem(text = "About Apple Music & Privacy", onClick = { /*TODO*/ })
                    TextItem(text = "Apple Music Terms & Conditions", onClick = { /*TODO*/ })
                    TextItem(text = "Acknowledgements", onClick = { /*TODO*/ })
                    TextItem(text = "Provide Feedback", onClick = { /*TODO*/ })
                    TextItem(text = "Get Support", onClick = { /*TODO*/ })
                    TextStatusItem(text = "Version", status = "4.1.1 (1269", onClick = { /*TODO*/ })
                }

                Text(
                    text = "Copyright © 2015-2023 Apple Inc. ALl rights reserved.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    style = MaterialTheme.typography.caption.copy(color = Color.Gray),
                    textAlign = TextAlign.Center
                )
            }
        }

        AnimatedVisibility(visible = visibleThemeDialog) {
            ThemeDialog(themeMode = themeMode, onDismissRequest = { visibleThemeDialog = false })
        }
    }

    BackHandler {
        onClose()
    }
}

@Composable
private fun ThemeDialog(
    themeMode: ThemeMode,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        val changeTheme: (ThemeMode) -> Unit = { themeMode ->
            onDismissRequest()
            ThemeManager.setThemeMode(themeMode)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    color = MaterialTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
        ) {
            Text(
                text = "Theme",
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
            )

            Column(modifier = Modifier.padding(top = 8.dp)) {
                ThemeMode.values().forEach {
                    RadioItem(
                        text = it.text, selected = themeMode == it,
                        onClick = {
                            changeTheme(it)
                        }
                    )
                }
            }

            Text(
                text = "Cancel",
                modifier = Modifier.align(Alignment.End),
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary),
            )
        }
    }
}

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
                selectedColor = MaterialTheme.colors.primary
            )
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun Section(title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier.padding(vertical = 8.dp)) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.primary)
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            content()
        }
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
        Text(text = text, style = MaterialTheme.typography.body1)
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
        Text(text = text, style = MaterialTheme.typography.body1)
        Text(text = status, style = MaterialTheme.typography.body2.copy(color = Color.Gray))
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
                style = MaterialTheme.typography.body1
            )
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.primary,
                    checkedTrackColor = MaterialTheme.colors.primary.copy(alpha = 0.3f),
//                    uncheckedThumbColor = Color.White,
//                    uncheckedTrackColor = Color.LightGray
                ),
            )
        }
    }
}