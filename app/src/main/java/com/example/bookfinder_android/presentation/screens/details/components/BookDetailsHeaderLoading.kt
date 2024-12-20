package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun BookDetailsHeaderLoading() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        LoadingImagePlaceholder()

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .height(128.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .width(100.dp)
                    .height(14.dp)
                    .placeholder(
                        visible = true,
                        color = Color.LightGray,
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White,
                            progressForMaxAlpha = 0.1f
                        )
                    )
            ) {}

            Row(
                modifier = Modifier
                    .width(100.dp)
                    .height(16.dp)
                    .placeholder(
                        visible = true,
                        color = Color.LightGray,
                        highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                    )
            ) {}

            Row(
                modifier = Modifier
                    .width(100.dp)
                    .height(14.dp)
                    .placeholder(
                        visible = true,
                        color = Color.LightGray,
                        highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
                    )
            ) {}
        }
    }
}
