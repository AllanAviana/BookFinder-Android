package com.example.bookfinder_android.data.api

import com.example.bookfinder_android.data.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 10
    ): BooksResponse
}