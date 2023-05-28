package com.example.applemusic.widget

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.applemusic.R

@Composable
fun AutoCompleteCard(inputText: String, autoCompleteText: String ="Queencard") {
    var remainForwardText by remember {
        mutableStateOf<String>("")
    }
    var remainBackwardText by remember {
        mutableStateOf<String>("")
    }
    LaunchedEffect(inputText) {
        val index = autoCompleteText.indexOf(inputText)
        Log.d("daeYoung", "index: $index inputText: $inputText")
        if (index != -1) {
            remainForwardText = autoCompleteText.substring(0, index)
            remainBackwardText = autoCompleteText.substring(index + inputText.length)
            Log.d("daeYoung", "앞: $remainForwardText 뒤: $remainBackwardText")
        }
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)) {
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            painter = painterResource(id = R.drawable.baseline_search_24),
            contentDescription = "search"
        )

        Text(text = remainForwardText, color = colorResource(id = R.color.light_color))
        Text(text = inputText)
        Text(text = remainBackwardText, color = colorResource(id = R.color.light_color))
    }
    Divider(thickness = 1.dp)
}