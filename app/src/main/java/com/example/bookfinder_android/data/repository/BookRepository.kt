package com.example.bookfinder_android.data.repository

import com.example.bookfinder_android.data.api.BookApi
import com.example.bookfinder_android.data.model.BooksResponse
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val bookApi: BookApi
) {
    suspend fun getBooks(query: String, maxResults: Int = 10): BooksResponse {
       return  bookApi.getBooks(query, maxResults)
    }
}