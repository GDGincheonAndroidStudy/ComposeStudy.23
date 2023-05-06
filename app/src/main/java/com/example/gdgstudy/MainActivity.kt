package com.example.gdgstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gdgstudy.ui.theme.GdgStudyTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isLight by remember {
                mutableStateOf(true)
            }
            GdgStudyTheme(darkTheme = isLight) {
//                            MySootheApp()
                Column() {
                    Text(
                        text = "${MaterialTheme.colors.primary}",
                        color = MaterialTheme.colors.primary
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        Text(text = "$isLight")
                    }
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(text = "${isLight} 1")
                    }
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                        Text(text = "${isLight} 2")
                    }
                    Button(onClick = { isLight = !isLight }) {
                        Text(text = "테마 바꾸기")
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(backgroundColor = LocalContentColor.current)
                    ) {
                        Text(text = "위 버튼과 대비되는 테마")
                    }
                    TextField(
                        value = "",
                        onValueChange = {},
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colors.onSurface.copy(
                                alpha = 1.0f
                            )
                        )
                    )
                    FloatingActionButton(onClick = { /*TODO*/ }) {

                    }
                }
            }

        }
    }
}


@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.h3,
//            modifier = Modifier.paddingFromBaseline(
//                top = 24.dp, bottom = 8.dp
//            )
        )
        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int,
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row {
            Image(
                painter = painterResource(drawable),
                contentDescription = null
            )
            Text(
                text = stringResource(text)
            )
        }
    }
}


@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(10) { item ->
            AlignYourBodyElement(drawable = R.drawable.image, text = R.string.ab1_inversions)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(120.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(10) {
            FavoriteCollectionCard(
                drawable = R.drawable.image,
                text = R.string.fc2_nature_meditations,
                modifier = Modifier.height(56.dp)
            )
        }
    }
}


@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(id = title).uppercase(
                Locale.getDefault()
            ),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.main_color))
            .padding(16.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar()
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        modifier,
        backgroundColor = MaterialTheme.colors.background
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun MySootheApp() {
    GdgStudyTheme() {
        Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}