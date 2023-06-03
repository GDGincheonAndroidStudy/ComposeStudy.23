package com.gdg.composestudy23_5week.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.gdg.composestudy23_5week.presentation.ScreenState

@Composable
fun KawaiBottomNavigation(screenState: ScreenState, onStateChange: (ScreenState) -> Unit) {
    BottomNavigation(modifier = Modifier.drawBehind {
        drawLine(
            color = Color.DarkGray,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f),
            strokeWidth = 2f
        )
    }, backgroundColor = MaterialTheme.colors.surface) {
        val style = MaterialTheme.typography.caption.copy(fontSize = 9.sp)

        KawaiBottomNavigationItem(
            currentState = screenState,
            state = ScreenState.ListenNow,
            icon = Icons.Filled.PlayArrow,
            onStateChange = onStateChange,
            style = style,
        )
        KawaiBottomNavigationItem(
            currentState = screenState,
            state = ScreenState.Browse,
            icon = Icons.Filled.List,
            onStateChange = onStateChange,
            style = style
        )
        KawaiBottomNavigationItem(
            currentState = screenState,
            state = ScreenState.Radio,
            icon = Icons.Filled.Place,
            onStateChange = onStateChange,
            style = style
        )
        KawaiBottomNavigationItem(
            currentState = screenState,
            state = ScreenState.Library,
            icon = Icons.Filled.DateRange,
            onStateChange = onStateChange,
            style = style
        )
        KawaiBottomNavigationItem(
            currentState = screenState,
            state = ScreenState.Search,
            icon = Icons.Filled.Search,
            onStateChange = onStateChange,
            style = style
        )
    }
}

@Composable
private fun RowScope.KawaiBottomNavigationItem(
    currentState: ScreenState,
    state: ScreenState,
    icon: ImageVector,
    onStateChange: (ScreenState) -> Unit,
    style: TextStyle = LocalTextStyle.current
) {
    BottomNavigationItem(
        selected = currentState == state,
        onClick = { onStateChange(state) },
        icon = {
            Icon(imageVector = icon, contentDescription = "Bottom Navigation Item ${state.text}")
        },
        label = {
            Text(text = state.text, style = style)
        },
        selectedContentColor = MaterialTheme.colors.primary,
        unselectedContentColor = Color.Gray
    )
}