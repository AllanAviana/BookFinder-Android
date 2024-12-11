package com.example.bookfinder_android.presentation.screens.home.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GenderOptionCard(onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.size(65.dp),
        colors = cardColors(Color(0xFF4D89FF))
    ) {
    }
}