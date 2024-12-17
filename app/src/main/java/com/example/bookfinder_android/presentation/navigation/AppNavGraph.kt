package com.example.bookfinder_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookfinder_android.presentation.screens.details.DetailsScreen
import com.example.bookfinder_android.presentation.screens.home.HomeScreen
import com.example.bookfinder_android.presentation.viewmodel.BookViewModel

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {

    val bookViewModel: BookViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(
                navController = navController,
                bookViewModel = bookViewModel
            )
        }
        composable(Routes.Details.route) {
            DetailsScreen(navController)
        }
    }
}