package com.example.bookfinder_android.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.bookfinder_android.R
import com.example.bookfinder_android.presentation.screens.home.components.BookCard
import com.example.bookfinder_android.presentation.screens.home.components.BookList
import com.example.bookfinder_android.presentation.screens.home.components.GenderSelection
import com.example.bookfinder_android.presentation.screens.home.components.HeaderWithSearchBar

@Composable
fun HomeScreen(){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()


        ) {
        item {

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding( top = 32.dp)
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

            BookList()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}