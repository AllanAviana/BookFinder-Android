package com.example.bookfinder_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BooksFinderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}