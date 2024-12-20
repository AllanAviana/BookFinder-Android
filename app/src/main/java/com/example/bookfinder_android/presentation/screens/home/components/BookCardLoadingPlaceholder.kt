package com.example.bookfinder_android.presentation.screens.home.components

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material3.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun BookCardLoadingPlaceholder() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(270.dp)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(140.dp)
                .height(200.dp)
                .placeholder(
                    visible = true,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(16.dp),
                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)

                )
                .zIndex(1f)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .align(Alignment.BottomCenter),
            colors = cardColors(Color.White),
            elevation = cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(20.dp),
            onClick = {}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.95f)
                    .padding(start = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(14.dp)
                        .placeholder(
                            visible = true,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(4.dp)
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(14.dp)
                        .placeholder(
                            visible = true,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(4.dp)
                        )
                )
            }
        }
    }
}