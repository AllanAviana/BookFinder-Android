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
import com.example.bookfinder_android.data.model.Home
import com.example.bookfinder_android.presentation.viewmodel.BookViewModel

@Composable
fun BookList(navController: NavHostController, data: Home, bookViewModel: BookViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        data.presented.items?.chunked(2)?.forEachIndexed { index, bookChunk ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            )  {
                BookCard(
                    title = bookChunk[0].volumeInfo.title,
                    author = bookChunk[0].volumeInfo.authors?.getOrNull(0) ?: "Unknown",
                    imageRes = bookChunk[0].volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://") ?: "",
                    onClick = { navController.navigate("details") },
                    bookViewModel = bookViewModel,
                    item = bookChunk[0]
                )

                if (bookChunk.size > 1) {
                    BookCard(
                        title = bookChunk[1].volumeInfo.title,
                        author = bookChunk[1].volumeInfo.authors?.getOrNull(0) ?: "Unknown",
                        imageRes = bookChunk[1].volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://") ?: "",
                        onClick = { navController.navigate("details") },
                        bookViewModel = bookViewModel,
                        item = bookChunk[1]
                    )
                }
            }
        }
    }
}