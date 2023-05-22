package com.gdg.composestudy23_5week.screen.search_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gdg.composestudy23_5week.component.CustomTextField

/**
 * tabRow 밑줄 색 변경
 * https://www.android--code.com/2022/03/jetpack-compose-tabrow-indicator-color.html
 */
@Composable
fun SearchDetailScreen(
    navigateToBack: () -> Unit
) {
    val tabIndex = remember { mutableStateOf(0) }
    val tabs = listOf("AppleMusic", "보관함")
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTextField(
            navigateToBack
        )
        TabRow(
            selectedTabIndex = tabIndex.value,
            backgroundColor = Color.White,
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[tabIndex.value]),
                    color = Color.Red
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex.value == index,
                    text = { Text(text = title) },
                    onClick = { tabIndex.value = index },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Gray
                )
            }
        }
            when(tabIndex.value) {
                0 -> AppleMusicScreen()
                1 -> SaveListScreen()
            }

    }
}