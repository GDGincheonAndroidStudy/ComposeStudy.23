package com.gdg.composestudy23_5week.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.component.CustomScaffold

@Composable
fun SearchScreen(
    navigateToSearchDetail: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                backgroundColor = Color.White,
                actions = {
                    IconButton(onClick = {  }) {
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .background(Color.LightGray)
                        .clickable {
                            navigateToSearchDetail()
                        },
                    text = "보관함",

                )
            }
        }
    )
}

@Preview
@Composable
fun SearchScreenPreview() {
    //SearchScreen()
}