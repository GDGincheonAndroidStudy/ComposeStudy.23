package com.gdg.composestudy23_5week.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.component.CustomScaffold

@Composable
fun SearchScreen() {
    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                backgroundColor = Color.White,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(
                            id = R.drawable.baseline_more_vert_24,),
                            contentDescription = null,
                            tint = Color.Red
                        )
                    }
                }
            )
        },
        content = { PaddingValues ->
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(PaddingValues)
            ) {
                Text(text = "Search Screen")
            }
        }
    )
}