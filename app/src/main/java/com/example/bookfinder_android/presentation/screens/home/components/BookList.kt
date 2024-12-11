package com.example.bookfinder_android.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookfinder_android.R

@Composable
fun BookList() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(8) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BookCard(
                    title = "O Vendedor de Sonhos",
                    author = "Augusto Cury",
                    imageRes = R.drawable.img
                )
                BookCard(
                    title = "O Vendedor de Sonhos",
                    author = "Augusto Cury",
                    imageRes = R.drawable.img
                )
            }
        }
    }
}