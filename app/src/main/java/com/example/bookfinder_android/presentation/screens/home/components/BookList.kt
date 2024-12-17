package com.example.bookfinder_android.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.bookfinder_android.R
import com.example.bookfinder_android.data.model.Home

@Composable
fun BookList(navController: NavHostController, data: Home) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        data.presented.items?.chunked(2)!!.forEach { book ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BookCard(
                    title = book[0].volumeInfo.title,
                    author = book[0].volumeInfo.authors!![0],
                    imageRes = book[0].volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://") ?: "",
                    onClick = { navController.navigate("details") }
                )
                BookCard(
                    title = book[1].volumeInfo.title,
                    author = book[1].volumeInfo.authors!![0],
                    imageRes = book[1].volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://") ?: "",
                    onClick = { navController.navigate("details") }
                )
            }
        }


    }
}