package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.bookfinder_android.data.model.Details

@Composable
fun DetailImageWithShadow(modifier: Modifier, data: Details){
    Box(
        modifier = modifier
            .size(width = 260.dp, height = 354.dp)
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
}