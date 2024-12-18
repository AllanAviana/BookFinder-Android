package com.example.bookfinder_android.presentation.screens.home.components

import android.util.Log
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.example.bookfinder_android.R
import com.example.bookfinder_android.data.model.Item
import com.example.bookfinder_android.presentation.viewmodel.BookViewModel

@Composable
fun BookCard(
    title: String,
    author: String,
    imageRes: String,
    onClick: () -> Unit,
    bookViewModel: BookViewModel,
    item: Item
) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(270.dp)
            .padding(horizontal = 8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = imageRes,
                error = painterResource(R.drawable.img),
                onError = { Log.e("Coil", "Erro ao carregar imagem: $imageRes") },
                onSuccess = { Log.d("Coil", "Imagem carregada com sucesso: $imageRes") }
            )
            ,
            contentDescription = null,
            modifier = Modifier
                .width(140.dp)
                .height(220.dp)
                .clip(RoundedCornerShape(16.dp))
                .align(Alignment.TopCenter)
                .zIndex(1f),
            contentScale = ContentScale.FillBounds
        )
        Log.d("BookCard", "Image URL: $imageRes")

        Card(
            onClick = {
                bookViewModel.updateDetails(item)
                onClick()
                      },
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
                    maxLines = 1
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