package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material3.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun DetailsLoading() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4D89FF))
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {

            LoadingImagePlaceholder(width = 260, height = 354, modifier = Modifier.align(Alignment.TopCenter))

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(0.63f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 16.dp)
                    .padding(top = 32.dp)
            ) {
                item {
                    BookDetailsHeaderLoading()
                    Spacer(modifier = Modifier.height(80.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .width(70.dp)
                                .height(14.dp)
                                .placeholder(
                                    visible = true,
                                    color = Color.LightGray,
                                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)

                                )
                        )

                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(14.dp)
                                .placeholder(
                                    visible = true,
                                    color = Color.LightGray,
                                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)

                                )
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.26f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(60.dp)
                                .height(14.dp)
                                .placeholder(
                                    visible = true,
                                    color = Color.LightGray,
                                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                                )
                        )

                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(RoundedCornerShape(100.dp))
                                .placeholder(
                                    visible = true,
                                    color = Color.LightGray,
                                    highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                                )
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    DescriptionLoading()
                }
            }
        }
    }
}