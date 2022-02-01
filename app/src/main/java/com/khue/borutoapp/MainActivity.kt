package com.khue.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.khue.borutoapp.navigation.SetUpNavigation
import com.khue.borutoapp.ui.theme.BorutoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
@ExperimentalPagerApi
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppTheme {
                navController = rememberNavController()
                SetUpNavigation(navController = navController)
            }
        }
    }

    // Happy new year - I'm will become a pro coder
}
