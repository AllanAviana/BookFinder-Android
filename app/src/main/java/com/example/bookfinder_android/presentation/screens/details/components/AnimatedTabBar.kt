package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedTabBar(selectedTab: Int, toOverview: () -> Unit, toBookDetails: () -> Unit) {
    val animatedProgress by animateFloatAsState(
        targetValue = selectedTab.toFloat(),
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
        )
    )

    Box {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(0.55f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TabItem(
                    text = "Overview",
                    isSelected = selectedTab == 0,
                    onClick = { toOverview() }
                )

                TabItem(
                    text = "Book Details",
                    isSelected = selectedTab == 1,
                    onClick = { toBookDetails() }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp)

                    .drawBehind {
                        val tabWidth = size.width / 10

                        drawRoundRect(
                            color = Color(0xFF1E64C3),
                            topLeft = Offset(
                                x = tabWidth * animatedProgress * (3.3).toFloat(),
                                y = 0f
                            ),
                            size = Size(
                                width = tabWidth,
                                height = 18f
                            ),
                            cornerRadius = CornerRadius(
                                x = 12.dp.toPx(),
                                y = 12.dp.toPx()
                            )
                        )
                    }
            )
        }
    }
}