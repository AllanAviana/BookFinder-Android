package com.example.bookfinder_android.data.model


sealed class HomeUiState<out T>{
    data class Success<out T>(val data: T): HomeUiState<T>()
    data class Error(val message: String): HomeUiState<Nothing>()
    object Loading: HomeUiState<Nothing>()
}

data class Home(
    val horror: BooksResponse = BooksResponse(
        kind = "",
        totalItems = 0
    ),
    val romance: BooksResponse = BooksResponse(
        kind = "",
        totalItems = 0
    ),
    val scienceFiction: BooksResponse = BooksResponse(
        kind = "",
        totalItems = 0
    ),
    val presented: BooksResponse = BooksResponse(
        kind = "",
        totalItems = 0
    )
)
