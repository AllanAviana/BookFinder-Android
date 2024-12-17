package com.example.bookfinder_android.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun BookCard(title: String, author: String, imageRes: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(270.dp)
            .padding(horizontal = 8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .width(140.dp)
                .height(220.dp)
                .align(Alignment.TopCenter)
                .zIndex(1f)
        )

        Card(
            onClick = { onClick()},
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .align(Alignment.BottomCenter),
            colors = cardColors(Color.White),
            elevation = cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.95f)
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = author,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}