package com.gdg.composestudy23_5week.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gdg.composestudy23_5week.presentation.radio.Album
import com.gdg.composestudy23_5week.presentation.radio.RadioScreen
import com.gdg.composestudy23_5week.presentation.search.SearchScreen
import com.gdg.composestudy23_5week.presentation.settings.SettingsScreen
import com.gdg.composestudy23_5week.ui.components.Header
import com.gdg.composestudy23_5week.ui.components.KawaiBottomNavigation
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
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

                    var visibleSettings by remember {
                        mutableStateOf(false)
                    }

                    val sheetState = rememberModalBottomSheetState(
                        initialValue = ModalBottomSheetValue.Hidden
                    )

                    var sheetAlbum by remember {
                        mutableStateOf<Album?>(null)
                    }

                    val coroutineScope = rememberCoroutineScope()

                    val showSheet: () -> Unit = {
                        coroutineScope.launch {
                            sheetState.show()
                        }
                    }
                    val hideSheet: () -> Unit = {
                        coroutineScope.launch {
                            sheetState.hide()
                        }
                    }

                    ModalBottomSheetLayout(
                        sheetContent = {
                            MainBottomSheet(sheetAlbum = sheetAlbum) {
                                hideSheet()
                            }
                        }, sheetState = sheetState,
                        scrimColor = Color.Black.copy(alpha = 0.32f)
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Header(
                                title = screenState.text,
                                subHeaderPositionY = if(screenState == ScreenState.Radio) subHeaderPositionY else 0f,
                                visibleSettings = true,
                                onClickSettings = {
                                    visibleSettings = true
                                },
                            )
                            when (screenState) {
                                ScreenState.ListenNow -> KAWAI(modifier = Modifier.weight(1f))
                                ScreenState.Browse -> KAWAI(modifier = Modifier.weight(1f))
                                ScreenState.Radio -> RadioScreen(
                                    modifier = Modifier.weight(1f),
                                    onPositionYChange = { subHeaderPositionY = it },
                                    onExpandAlbum = {
                                        sheetAlbum = it
                                        showSheet()
                                    }
                                )

                                ScreenState.Library -> KAWAI(modifier = Modifier.weight(1f))
                                ScreenState.Search -> SearchScreen(modifier = Modifier.weight(1f))
                            }
                            KawaiBottomNavigation(
                                screenState = screenState,
                                onStateChange = {
                                    screenState = it
                                }
                            )
                        }
                    }

                    AnimatedVisibility(
                        visible = visibleSettings,
                        enter = fadeIn() + slideInVertically(
                            initialOffsetY = {
                                it
                            }
                        ),
                        exit = fadeOut() + slideOutVertically(
                            targetOffsetY = {
                                it
                            }
                        )
                    ) {
                        SettingsScreen(
                            onClose = {
                                visibleSettings = false
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun KAWAI(modifier: Modifier) {
    Box(modifier = modifier)
}