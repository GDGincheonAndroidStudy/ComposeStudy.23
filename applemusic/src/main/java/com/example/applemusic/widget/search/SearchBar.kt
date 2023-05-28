package com.example.applemusic.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.example.applemusic.R
import com.example.applemusic.data.SearchState
import com.example.applemusic.screen.search.SearchViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(viewModel: SearchViewModel) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        delay(700)
        keyboardController?.show()
    }



    LaunchedEffect(viewModel.text.value) {
        if (viewModel.text.value.isNotEmpty()) {
            viewModel.setState(SearchState.Searching)
        } else {
            viewModel.setState(SearchState.Empty)
        }

    }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        value = viewModel.text.value,
        onValueChange = { viewModel.setText(it) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "",
                tint = MaterialTheme.colors.secondary,
            )
        },
        trailingIcon = {
            if (viewModel.text.value.isNotEmpty()) {
                IconButton(onClick = { viewModel.setText("") }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        },
        placeholder = { Text(text = stringResource(id = R.string.search_searchBar_hint)) },
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = MaterialTheme.colors.secondary,
            disabledLabelColor = Color(0xffd8e6ff),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            viewModel.addList(viewModel.text.value)
            viewModel.setText("")
            viewModel.setState(SearchState.Fill)
        })

    )
}