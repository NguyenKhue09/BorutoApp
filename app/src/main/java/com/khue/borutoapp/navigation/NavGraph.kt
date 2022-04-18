package com.khue.borutoapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.khue.borutoapp.presentation.screens.details.DetailsScreen
import com.khue.borutoapp.presentation.screens.home.HomeScreen
import com.khue.borutoapp.presentation.screens.search.SearchScreen
import com.khue.borutoapp.presentation.screens.splash.SplashScreen
import com.khue.borutoapp.presentation.screens.welcome.WelcomeScreen
import com.khue.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun SetUpNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            println("Running")
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }

    }
}