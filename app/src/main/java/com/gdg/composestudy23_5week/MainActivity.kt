package com.gdg.composestudy23_5week

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gdg.composestudy23_5week.ui.components.Header
import com.gdg.composestudy23_5week.ui.components.KawaiBottomNavigation
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudy235weekTheme {
                Surface {
                    var screenState by remember {
                        mutableStateOf(ScreenState.Radio)
                    }
                    var subHeaderPositionY by remember {
                        mutableStateOf(0f)
                    }

                    Column(modifier = Modifier.fillMaxSize()) {
                        Header(title = "Radio", subHeaderPositionY = subHeaderPositionY)
                        when (screenState) {
                            ScreenState.ListenNow -> {}
                            ScreenState.Browse -> {}
                            ScreenState.Radio -> RadioScreen(modifier = Modifier.weight(1f)) {
                                subHeaderPositionY = it
                            }

                            ScreenState.Library -> {}
                            ScreenState.Search -> {}
                        }
                        KawaiBottomNavigation(screenState = screenState, onStateChange = {
                            screenState = it
                        })
                    }
                }
            }
        }
    }
}