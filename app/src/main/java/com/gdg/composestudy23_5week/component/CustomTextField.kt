package com.gdg.composestudy23_5week.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.composestudy23_5week.R

@Composable
fun CustomTextField(
    navigateToBack: () -> Unit
) {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.LightGray,
            cursorColor = Color.Red,
            focusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "back",
                tint = Color.Red,
                modifier = Modifier.clickable {
                    navigateToBack()
                }
            )
        },

        trailingIcon = {
            if (text.isNotEmpty()) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "close"
                )
            }
        }
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    //CustomTextField()
}