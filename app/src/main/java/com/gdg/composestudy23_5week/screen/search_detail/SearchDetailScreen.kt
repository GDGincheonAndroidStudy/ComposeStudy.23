package com.gdg.composestudy23_5week.screen.search_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gdg.composestudy23_5week.component.CustomTextField

@Composable
fun SearchDetailScreen(
    navigateToBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTextField(
            navigateToBack
        )
    }
}