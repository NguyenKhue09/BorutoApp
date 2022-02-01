package com.khue.borutoapp.presentation.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.khue.borutoapp.R
import com.khue.borutoapp.ui.theme.topAppBarBackgroundColor
import com.khue.borutoapp.ui.theme.topAppBarContentColor


@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(
                onClick = onSearchClicked
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        }
    )
}