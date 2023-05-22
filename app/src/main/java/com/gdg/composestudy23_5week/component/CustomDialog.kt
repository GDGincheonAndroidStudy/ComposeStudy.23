package com.gdg.composestudy23_5week.component

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.AlertDialog
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ThemeDialog() {
    var isOpenDialog = remember { mutableStateOf(true) }

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
                Text(text = "취소", color = Color.Red, modifier = Modifier.padding(end = 16.dp, bottom = 16.dp))
            }
        )
    }
}

@Composable
fun ThemeRadioButton() {
    val selectedValue = remember { mutableStateOf("") }
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

    val items = listOf<String>("밝게", "어둡게", "시스템 기본")

    Column(Modifier.padding(8.dp)) {
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.selectable(
                    selected = isSelectedItem(item),
                    onClick = { onChangeState(item) },
                    role = Role.RadioButton
                )
            ) {
                RadioButton(
                    selected = isSelectedItem(item),
                    colors = RadioButtonDefaults.colors(Color.Red) ,
                    onClick = {
                        if (item == "밝게") {

                        } else if (item == "어둡게") {
                            // isSystemInDarkTheme()

                        } else {

                        }
                    }
                )
                Text(text = item, modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp), color = Color.Black, fontSize = 16.sp)
            }
        }
    }
}

@Preview
@Composable
fun DialogPreview() {
    ThemeDialog()
}