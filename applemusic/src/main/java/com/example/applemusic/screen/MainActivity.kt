package com.example.applemusic.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applemusic.data.BottomNavItem
import com.example.applemusic.ui.theme.GdgStudyTheme
import com.example.applemusic.widget.BottomNavigation
import com.example.applemusic.R
import com.example.applemusic.screen.search.SearchActivity
import com.example.applemusic.widget.SettingDialog


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDropDownMenuExpanded by remember { mutableStateOf<Boolean>(false) }

            val navController = rememberNavController()
            GdgStudyTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        AppleMusicTopAppBar(isDropDownMenuExpanded = isDropDownMenuExpanded) {
                            isDropDownMenuExpanded = !isDropDownMenuExpanded
                        }
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
                                SearchScreen() { moveSearchActivity() }
                            }
                        }
                    }
                }

            }
        }
    }

    private fun moveSearchActivity() {
        startActivity(Intent(this, SearchActivity::class.java))
    }
}

@Composable
fun AppleMusicTopAppBar(isDropDownMenuExpanded: Boolean, showDropDownMenu: () -> Unit) {
    TopAppBar(
        title = { Text(text = "") },
        actions = {
            IconButton(
                onClick = { showDropDownMenu() }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "show Option Menu")
            }
            DropdownMenu(
                modifier = Modifier.wrapContentSize(),
                offset = DpOffset(0.dp, (-35).dp),
                expanded = isDropDownMenuExpanded,
                onDismissRequest = { showDropDownMenu() }) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = "설정")
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = "계정")
                }
            }
        },
    )

}