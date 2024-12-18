package com.example.bookfinder_android.data.model

sealed class DetailsUiState<out t>{
    data class Success<out t>(val data: t): DetailsUiState<t>()
    data class Error(val message: String): DetailsUiState<Nothing>()
    object Loading: DetailsUiState<Nothing>()
}

data class Details(
    val title: String = "",
    val author: String = "",
    val description: String = "",
    val imageRes: String = "",
    val date: String = "",
    val rating: Double = 0.0,
    val publisher: String = "",
    val category: String = "",
    val pages: Int = 0,
    val buyLink: String = ""

)
