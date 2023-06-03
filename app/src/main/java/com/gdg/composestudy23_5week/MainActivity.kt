package com.gdg.composestudy23_5week

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gdg.composestudy23_5week.data.ThemeManager
import com.gdg.composestudy23_5week.presentation.radio.Album
import com.gdg.composestudy23_5week.presentation.radio.RadioScreen
import com.gdg.composestudy23_5week.presentation.search.SearchScreen
import com.gdg.composestudy23_5week.presentation.settings.SettingsScreen
import com.gdg.composestudy23_5week.supports.noRippleClickable
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
                            val sheetAlbum = sheetAlbum
                                ?: return@ModalBottomSheetLayout Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .noRippleClickable { }
                                        .padding(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Something wrong... Try it later",
                                        style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.error),
                                        textAlign = TextAlign.Center
                                    )
                                }

                            Column(
                                modifier = Modifier
                                    .background(MaterialTheme.colors.background)
                                    .noRippleClickable(hideSheet)
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(0.25f)
                                            .clip(RoundedCornerShape(12.dp))
                                            .then(
                                                if (ThemeManager.collectIsDarkColorPalette()) Modifier else Modifier.border(
                                                    width = 1.dp,
                                                    color = Color.LightGray,
                                                    shape = RoundedCornerShape(12.dp)
                                                )
                                            )
                                            .aspectRatio(1f),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = sheetAlbum.imageId),
                                            contentDescription = "Album image"
                                        )

                                        Box(
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .fillMaxSize(0.5f)
                                                .background(color = Color.LightGray.copy(alpha = 0.75f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.PlayArrow,
                                                contentDescription = "Play",
                                                modifier = Modifier.fillMaxSize(0.7f),
                                                tint = Color.White,
                                            )
                                        }
                                    }

                                    Text(
                                        text = sheetAlbum.section,
                                        style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .weight(1f)
                                    )
                                }
                                Divider()
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .then(
                                            if (ThemeManager.collectIsDarkColorPalette()) Modifier.clickable(
                                                onClick = hideSheet
                                            ) else Modifier.noRippleClickable(onClick = hideSheet)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Share,
                                        contentDescription = "Share",
                                        tint = MaterialTheme.colors.primary
                                    )
                                    Text(
                                        text = "Share Station",
                                        modifier = Modifier.padding(start = 16.dp),
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                            }
                        }, sheetState = sheetState,
                        scrimColor = Color.Black.copy(alpha = 0.32f)
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Header(
                                title = "Radio",
                                subHeaderPositionY = subHeaderPositionY,
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
                                ScreenState.Search -> SearchScreen()
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