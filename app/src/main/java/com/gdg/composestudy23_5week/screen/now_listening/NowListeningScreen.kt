package com.gdg.composestudy23_5week.screen.now_listening

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.component.CustomScaffold

@Composable
fun NowListeningScreen(
    navigateToSetting: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }

    CustomScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                backgroundColor = Color.White,
                actions = {
                    IconButton(onClick = { isDropDownMenuExpanded = true }) {
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
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues)
            ) {
                Box(modifier =Modifier.wrapContentSize(Alignment.TopEnd)){
                    DropdownMenu(
                        // modifier = Modifier.wrapContentSize(),
                        expanded = isDropDownMenuExpanded,
                        onDismissRequest = { isDropDownMenuExpanded = false }
                    ) {
                        Column(
                          //  modifier = Modifier.wrapContentSize(Alignment.TopEnd)
                        ) {
                            DropdownMenuItem(onClick = { navigateToSetting() }) {
                                Text(text = "설정")
                            }
                            DropdownMenuItem(onClick = { println("계정") }) {
                                Text(text = "계정")
                            }
                        }
                    }
                }
                Text(text = "Now Listening Screen")
            }
        }
    )
}

@Composable
fun CustomDropDownMenu(
    isDropDownMenuExpanded: MutableState<Boolean>,
){
    Box(
        modifier = Modifier.wrapContentSize(Alignment.TopEnd)
    ) {
        DropdownMenu(
            modifier = Modifier.wrapContentSize(),
            expanded = isDropDownMenuExpanded.value,
            onDismissRequest = { isDropDownMenuExpanded.value = false }
        ) {
            DropdownMenuItem(onClick = {  }) {
                Text(text = "설정")
            }
            DropdownMenuItem(onClick = { /*TODO*/ }) {
                Text(text = "계정")
            }
        }
    }
}