package com.example.applemusic.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applemusic.R
import com.example.applemusic.widget.CategoryImageCard
import com.example.applemusic.widget.Title

@Composable
fun SearchScreen(moveActivity: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Title(title = stringResource(id = R.string.search_title))
        Spacer(modifier = Modifier.height(16.dp))

        SearchBar(moveActivity)

        ExperienceCard()

        Text(text = "카테고리 둘러보기", style = MaterialTheme.typography.h4, modifier = Modifier.padding(vertical = 16.dp))
        repeat(5) {
            Row(modifier = Modifier.padding(bottom = 8.dp)) {
                CategoryImageCard(modifier = Modifier.weight(0.5f))
                Spacer(modifier = Modifier.width(16.dp))
                CategoryImageCard(modifier = Modifier.weight(0.5f))
            }

        }


    }
}

@Composable
fun SearchBar(moveActivity: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { moveActivity() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = colorResource(id = R.color.real_light_color),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = stringResource(id = R.string.search_searchBar_hint),
                fontSize = 20.sp,
                color = colorResource(id = R.color.light_color)
            )
        }

    }
}

@Composable
fun ExperienceCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.sky_image),
                contentDescription = "null"
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 30.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "1개월 무료 체험하기", style = MaterialTheme.typography.h2)
                Text(text = "보유 중인 모든 기기에서 음악 보관함 전체를 즐길 수 있습니다. 1개월 무료 체험 후 ￦8,900/개월의 요금이 청구됩니다.")

                Button(
                    modifier = Modifier.width(200.dp),
                    onClick = { /*TODO*/ },
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.onSecondary
                    )
                ) {
                    Text(text = "무료 체험", modifier = Modifier)
                }
            }
        }
    }
}