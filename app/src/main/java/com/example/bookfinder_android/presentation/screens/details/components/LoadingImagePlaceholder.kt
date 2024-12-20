package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material3.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun LoadingImagePlaceholder(width: Int = 88, height: Int = 128, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
            .placeholder(
                visible = true,
                color = Color.LightGray,
                highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White),
                shape = RoundedCornerShape(0.dp)

            )
    )
}