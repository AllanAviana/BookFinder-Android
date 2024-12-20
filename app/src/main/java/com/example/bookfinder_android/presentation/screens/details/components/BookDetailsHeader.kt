package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.bookfinder_android.data.model.Details

@Composable
fun BookDetailsHeader(data: Details){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = data.imageRes),
            contentDescription = null,
            modifier = Modifier
                .width(88.dp)
                .height(128.dp)

        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .height(128.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = data.date,
                color = Color.Gray,
                fontSize = 14.sp
            )
            Text(text = data.title, fontSize = 14.sp,)
            Text(
                text = data.author,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}