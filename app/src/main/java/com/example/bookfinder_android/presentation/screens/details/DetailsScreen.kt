package com.example.bookfinder_android.presentation.screens.details


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.bookfinder_android.data.model.Details
import com.example.bookfinder_android.data.model.DetailsUiState
import com.example.bookfinder_android.presentation.screens.details.components.AnimatedTabBar
import com.example.bookfinder_android.presentation.screens.details.components.Description

import com.example.bookfinder_android.presentation.viewmodel.BookViewModel

@Composable
fun DetailsScreen(navController: NavHostController, bookViewModel: BookViewModel) {
   val detailsUiState by bookViewModel.detailsUiState.collectAsState()

    when(detailsUiState){
        is DetailsUiState.Loading -> DetailsLoading()
        is DetailsUiState.Success -> DetailsSuccess(navController, bookViewModel, (detailsUiState as DetailsUiState.Success<Details>).data)
        is DetailsUiState.Error -> DetailsError()
    }
}

@Composable
fun DetailsError() {
}

@Composable
fun DetailsLoading() {
}

@Composable
fun DetailsSuccess(navController: NavHostController, bookViewModel: BookViewModel, data: Details) {
    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4D89FF))
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
                .size(30.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    navController.navigate("home")
                }
        )
        Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
            Box(
                modifier = Modifier
                    .size(width = 260.dp, height = 354.dp)
                    .align(Alignment.TopCenter)
                    .drawBehind {
                        val shadowColor = Color(0x4D000000)
                        val offsetX = 10.dp.toPx()
                        val offsetY = 4.dp.toPx()
                        val blurRadius = 10.dp.toPx()

                        drawIntoCanvas { canvas ->
                            val paint = Paint().apply {
                                asFrameworkPaint().apply {
                                    this.color = android.graphics.Color.TRANSPARENT
                                    this.setShadowLayer(
                                        blurRadius,
                                        offsetX,
                                        offsetY,
                                        shadowColor.toArgb()
                                    )
                                }
                            }
                            canvas.drawRect(
                                0f,
                                0f,
                                size.width,
                                size.height,
                                paint
                            )
                        }
                    }
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = data.imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }

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
                    Spacer(modifier = Modifier.height(60.dp))

                    AnimatedTabBar(
                        selectedTab = selectedTab,
                        toOverview = { selectedTab = 0 },
                        toBookDetails = { selectedTab = 1 }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Description(selectedTab, data)

                }
            }
        }
    }

}
