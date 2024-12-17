package com.example.bookfinder_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookfinder_android.presentation.screens.details.DetailsScreen
import com.example.bookfinder_android.presentation.screens.home.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(Routes.Details.route) {
            DetailsScreen(navController)

        }

    }
}