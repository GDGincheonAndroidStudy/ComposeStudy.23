package com.gdg.composestudy23_5week.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme

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
                ThemeRadioButton(isOpenDialog)
            },
            confirmButton = {
                Text(text = "저장", color = Color.Black, modifier = Modifier.padding(end = 16.dp, bottom = 16.dp))
            },
            dismissButton = {
                Text(text = "취소", color = Color.Red, modifier = Modifier.padding(end = 16.dp, bottom = 16.dp))
            }
        )
    }
}

@Composable
fun ThemeRadioButton(
    isOpenDialog: MutableState<Boolean>
) {
    val selectedValue = remember { mutableStateOf("") }
    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }
    val isChangeDarkTheme = remember { mutableStateOf(true) }

    ComposeStudy235weekTheme(isChangeDarkTheme.value, content = {})

    val items = listOf<String>("밝게", "어둡게", "시스템 기본")
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(items[1])
    }

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
                        selectedValue.value = item.also {// 테마 적용해주기
                            println(it)
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