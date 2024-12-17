package com.example.bookfinder_android.presentation.navigation

sealed class Routes(val route: String){
    object Home: Routes("home")
    object Details: Routes("details")
}