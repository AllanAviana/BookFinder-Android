package com.example.bookfinder_android.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bookfinder_android.presentation.screens.home.components.BookList
import com.example.bookfinder_android.presentation.screens.home.components.GenderSelection
import com.example.bookfinder_android.presentation.screens.home.components.HeaderWithSearchBar

@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding( top = 36.dp)
            ) {

                HeaderWithSearchBar()

                Spacer(modifier = Modifier.height(32.dp))

                GenderSelection()

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Recommended",
                    fontSize = 20.sp,
                    color = Color(0xFF1E64C3)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            BookList(navController)
        }
    }
}