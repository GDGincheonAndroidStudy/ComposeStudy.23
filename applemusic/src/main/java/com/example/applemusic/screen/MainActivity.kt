package com.example.applemusic.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applemusic.data.BottomNavItem
import com.example.applemusic.ui.theme.GdgStudyTheme
import com.example.applemusic.widget.BottomNavigation
import com.example.applemusic.R



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            GdgStudyTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "") },
                            actions = {
                                IconButton(
                                    onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_menu_24),
                                        contentDescription = "menu"
                                    )
                                }
                            },
//                            modifier = Modifier.drawBehind { drawLine(
//                                color = Color.DarkGray,
//                                start = Offset(x = 0f, y = 0f),
//                                end = Offset(x = size.width, y = 0f),
//                                strokeWidth = 2f
//                            ) }
                        )
                    },
                    bottomBar = { BottomNavigation(navController = navController) }) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colors.background
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = BottomNavItem.RadioScreen.screenRoute
                        ) {
                            composable(BottomNavItem.RadioScreen.screenRoute) {
                                RadioScreen()
                            }
                            composable(BottomNavItem.SearchScreen.screenRoute) {
                                SearchScreen()
                            }
                        }
                    }
                }

            }
        }
    }
}