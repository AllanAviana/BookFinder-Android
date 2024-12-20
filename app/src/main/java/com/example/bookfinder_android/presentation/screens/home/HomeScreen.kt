package com.example.bookfinder_android.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.example.bookfinder_android.data.model.Home
import com.example.bookfinder_android.data.model.HomeUiState
import com.example.bookfinder_android.presentation.viewmodel.BookViewModel
import com.example.bookfinder_android.presentation.screens.home.components.HomeError
import com.example.bookfinder_android.presentation.screens.home.components.HomeLoading
import com.example.bookfinder_android.presentation.screens.home.components.HomeSuccess

@Composable
fun HomeScreen(navController: NavHostController, bookViewModel: BookViewModel) {
    val homeUiState by bookViewModel.homeUiState.collectAsState()
    when(homeUiState){
        is HomeUiState.Success -> HomeSuccess(navController, bookViewModel, (homeUiState as HomeUiState.Success<Home>).data)
        is HomeUiState.Loading -> HomeLoading()
        is HomeUiState.Error -> HomeError()
    }
}




