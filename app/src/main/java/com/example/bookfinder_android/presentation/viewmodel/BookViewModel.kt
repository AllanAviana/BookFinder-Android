package com.example.bookfinder_android.presentation.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookfinder_android.data.model.BooksResponse
import com.example.bookfinder_android.data.model.Details
import com.example.bookfinder_android.data.model.DetailsUiState
import com.example.bookfinder_android.data.model.Home
import com.example.bookfinder_android.data.model.HomeUiState
import com.example.bookfinder_android.data.model.Item
import com.example.bookfinder_android.data.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel() {

    private val _books = MutableStateFlow<BooksResponse>(BooksResponse(
        kind = "",
        totalItems = 0
    )
    )
    val books: MutableStateFlow<BooksResponse> = _books

    private val _homeUiState = MutableStateFlow<HomeUiState<Home>>(HomeUiState.Loading)
    val homeUiState: MutableStateFlow<HomeUiState<Home>> = _homeUiState

    private val _detailsUiState = MutableStateFlow<DetailsUiState<Details>>(DetailsUiState.Loading)
    val detailsUiState: MutableStateFlow<DetailsUiState<Details>> = _detailsUiState

    init {
        viewModelScope.launch {
            getBooks()
        }
    }

    suspend fun getBooks() {
        val genders = listOf("horror", "romance", "Fiction")

        _homeUiState.value = HomeUiState.Loading
        delay(5000)
        var currenState = Home()
        genders.forEach { gender ->
            _books.value = bookRepository.getBooks(gender)

            currenState = when (gender) {
                "romance" -> {
                    currenState.copy(
                        romance = books.value,
                        presented = BooksResponse(
                            kind = "",
                            totalItems = 0,
                            items = ((currenState.presented.items ?: emptyList()) +
                                    (books.value.items?.filter { book -> book.volumeInfo.averageRating != null }
                                        ?: emptyList()))
                                .filterIsInstance<Item>()
                        )
                    )
                }
                "horror" -> {
                    currenState.copy(
                        horror = books.value,
                        presented = BooksResponse(
                            kind = "",
                            totalItems = 0,
                            items = ((currenState.presented.items ?: emptyList()) +
                                    (books.value.items?.filter { book -> book.volumeInfo.averageRating == null }
                                        ?: emptyList()))
                                .filterIsInstance<Item>()
                        )
                    )
                }
                "Fiction" -> {
                    currenState.copy(
                        scienceFiction = books.value,
                        presented = BooksResponse(
                            kind = "",
                            totalItems = 0,
                            items = ((currenState.presented.items ?: emptyList()) +
                                    (books.value.items?.filter { book -> book.volumeInfo.averageRating == null }
                                        ?: emptyList()))
                                .filterIsInstance<Item>()
                        )
                    )
                }
                else -> {
                    currenState
                }
            }
        }
        _homeUiState.value = HomeUiState.Success(currenState)
    }

    @SuppressLint("SuspiciousIndentation")
    fun updateDetails(item: Item) {
        viewModelScope.launch {
        _detailsUiState.value = DetailsUiState.Loading
            delay(2000)
        _detailsUiState.value = DetailsUiState.Success(
            Details(
                title = item.volumeInfo.title,
                author = item.volumeInfo.authors?.getOrNull(0) ?: "Unknown",
                description = item.volumeInfo.description ?: "No description available",
                imageRes = item.volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://") ?: "",
                date = item.volumeInfo.publishedDate ?: "Unknown",
                rating = item.volumeInfo.averageRating ?: 4.0,
                publisher = item.volumeInfo.publisher ?: "Unknown",
                category = item.volumeInfo.categories?.getOrNull(0) ?: "Unknown",
                pages = item.volumeInfo.pageCount ?: 0,
                buyLink = item.saleInfo?.buyLink?.replace("http://", "https://") ?: ""
            )
        )
            Log.d("BookViewModel", "Details: ${_detailsUiState.value}")
    }
    }

}