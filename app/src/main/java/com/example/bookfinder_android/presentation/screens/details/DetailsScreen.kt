package com.example.bookfinder_android.presentation.screens.details



import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.example.bookfinder_android.data.model.Details
import com.example.bookfinder_android.data.model.DetailsUiState
import com.example.bookfinder_android.presentation.screens.details.components.DetailsError
import com.example.bookfinder_android.presentation.screens.details.components.DetailsLoading
import com.example.bookfinder_android.presentation.screens.details.components.DetailsSuccess
import com.example.bookfinder_android.presentation.viewmodel.BookViewModel

@Composable
fun DetailsScreen(navController: NavHostController, bookViewModel: BookViewModel) {
   val detailsUiState by bookViewModel.detailsUiState.collectAsState()

    when(detailsUiState){
        is DetailsUiState.Loading -> DetailsLoading()
        is DetailsUiState.Success -> DetailsSuccess(navController, bookViewModel, (detailsUiState as DetailsUiState.Success<Details>).data)
        is DetailsUiState.Error -> DetailsError()
    }
}