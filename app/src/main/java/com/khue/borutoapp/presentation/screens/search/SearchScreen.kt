package com.khue.borutoapp.presentation.screens.search

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.khue.borutoapp.presentation.common.ListContent
import com.khue.borutoapp.ui.theme.statusBarColor


@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery
    val heroes = searchViewModel.searchHeroes.collectAsLazyPagingItems()
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.statusBarColor
    )

    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onCloseClicked = {
                    navController.popBackStack()
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(query = searchQuery)
                },
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                }
            )
        },
        content = {
            ListContent(heroes = heroes, navController = navController)
        }
    )
}