package com.example.bookfinder_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookfinder_android.data.model.BooksResponse
import com.example.bookfinder_android.data.model.Home
import com.example.bookfinder_android.data.model.HomeUiState
import com.example.bookfinder_android.data.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val _books = MutableStateFlow<BooksResponse>(BooksResponse(
    kind = "",
    totalItems = 0
))
    val books: MutableStateFlow<BooksResponse> = _books

    private val _homeUiState = MutableStateFlow<HomeUiState<Home>>(HomeUiState.Loading)
    val homeUiState: MutableStateFlow<HomeUiState<Home>> = _homeUiState

    init {
        viewModelScope.launch {
            getBooks("horror")
        }
    }

    suspend fun getBooks(query: String) {
        _books.value = bookRepository.getBooks(query)
        Log.d("BookViewModel", "Gender: $query Books: ${books.value}")

        val bookRecomended = books.value.items?.filter { book ->
            book.volumeInfo.averageRating == null
        }
        var currenState = Home()

        currenState = when (query) {
            "romance" -> {
                currenState.copy(
                    romance = books.value,
                    presented = books.value.copy(
                        items = bookRecomended?: emptyList()

                    )
                )
            }
            "horror" -> {
                currenState.copy(
                    horror = books.value,
                    presented = books.value.copy(
                        items = bookRecomended?: emptyList()

                    )
                )
            }
            else -> {
                currenState
            }
        }
        Log.d("BookViewModel", "Romance: ${currenState.presented}")

        _homeUiState.value = HomeUiState.Success(currenState)
    }
}