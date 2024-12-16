package com.example.bookfinder_android.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookfinder_android.R

@Composable
fun Description(selectedTab: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        if(selectedTab == 0) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.2f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "4.0",
                    fontSize = 24.sp,
                    color = Color(0xFF1E64C3)
                )

                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Um psicólogo decepcionado com a vida tenta o suicídio, mas é impedido de cometer o ato final por intermédio de um mendigo. Uma amizade peculiar surge e, logo, a dupla passa a tentar salvar pessoas ao apresentar um novo caminho para se viver.",
                fontSize = 18.sp
            )
        }
    }
}