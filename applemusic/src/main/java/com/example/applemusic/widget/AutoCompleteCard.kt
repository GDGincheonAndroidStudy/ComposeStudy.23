package com.example.applemusic.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.applemusic.R

@Composable
fun AutoCompleteCard(autoCompleteText: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)) {
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            painter = painterResource(id = R.drawable.baseline_search_24),
            contentDescription = "search"
        )
        Text(text = autoCompleteText)
    }
    Divider(thickness = 1.dp)
}