package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bookfinder_android.data.model.Details
import com.example.bookfinder_android.presentation.viewmodel.BookViewModel

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
            DetailImageWithShadow(modifier = Modifier.align(Alignment.TopCenter), data = data )

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
                    BookDetailsHeader(data = data)

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