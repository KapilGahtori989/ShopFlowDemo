package com.hammer.shopflow.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hammer.shopflow.Models.Model
import com.hammer.shopflow.R

@Preview(showBackground = true)
@Composable
fun CategorySection() {
    Column(modifier = Modifier
        .padding(start = 16.dp, top = 8.dp)
        .background(Color.Transparent)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Categories", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(
                "See All", color = Color.White, style = TextStyle(
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
        LazyRow(modifier = Modifier.padding(top = 8.dp)) {
            val list: List<Model> = listOf(
                Model(R.drawable.product_image, "Cleaners"),
                Model(R.drawable.categorysample2, "Toner"),
                Model(R.drawable.product_image, "Serums"),
                Model(R.drawable.categorysample2, "Moisturisers"),
                Model(R.drawable.product_image, "SunScreen")
            )
            items(list) { category ->
                Column(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable { },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                    ) {
                        Image(
                            painter = painterResource(category.productImage),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                    Text(category.productName, color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}
