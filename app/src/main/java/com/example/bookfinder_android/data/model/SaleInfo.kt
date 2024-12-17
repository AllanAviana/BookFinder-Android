package com.example.bookfinder_android.data.model

data class SaleInfo(
    val country: String,
    val saleability: String,
    val isEbook: Boolean,
    val listPrice: Price? = null,
    val retailPrice: Price? = null,
    val buyLink: String? = null
)
