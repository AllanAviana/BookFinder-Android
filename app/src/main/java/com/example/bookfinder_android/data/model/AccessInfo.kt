package com.example.bookfinder_android.data.model

data class AccessInfo(
    val country: String,
    val viewability: String,
    val embeddable: Boolean,
    val publicDomain: Boolean,
    val textToSpeechPermission: String,
    val epub: FormatAvailability,
    val pdf: FormatAvailability,
    val webReaderLink: String? = null
)

