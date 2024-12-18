package com.example.bookfinder_android.presentation.screens.details.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookfinder_android.R
import com.example.bookfinder_android.data.model.Details

@Composable
fun Description(selectedTab: Int, data: Details) {
    val context = LocalContext.current

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
                    text = "${data.rating}",
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
                text = data.description,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }else{
            val info = listOf(data.publisher, data.category, data.pages, data.buyLink)
            val title = listOf("Publisher", "Category", "pages", "Buy Link")
            info.forEach { info ->
                val tilte = when(info){
                    data.publisher -> title[0]
                    data.category -> title[1]
                    data.buyLink -> title[3]
                    else -> "pages"
                }
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(8.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = Color(0xFF1E64C3))
                      ,

                    )
                if (tilte == "Buy Link") {
                    Text(
                        text = "Buy Link: Click Here",
                        fontSize = 16.sp,
                        color = Color.Blue,
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(info.toString()))
                            context.startActivity(intent)}
                            .padding(top = 4.dp)
                    )
                } else {
                    Text(
                        text = "$tilte: $info",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp).padding(bottom = 16.dp)
                    )

                }
            }
        }
    }
}