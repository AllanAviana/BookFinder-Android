package com.example.bookfinder_android.data.model

data class BooksResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<Item>? = null
)

