package com.gdg.composestudy23_5week.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchDetailScreen(onNavigateUp: () -> Unit) {
    val viewModel: SearchDetailViewModel = hiltViewModel()

    Column {
        TextField(
            value = viewModel.text,
            onValueChange = { viewModel.text = it },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
            placeholder = {
                Text(
                    text = "아티스트, 노래, 가사 등",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray,
                    fontSize = 18.sp
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable(onClick = onNavigateUp)
                )
            },
            trailingIcon = if (viewModel.text.isEmpty()) null else {
                {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Reset",
                        modifier = Modifier.clickable { viewModel.text = "" }
                    )
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(50) {
                Text("Hello")
            }
        }
    }
}