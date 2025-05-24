package com.hammer.shopflow.layouts


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hammer.shopflow.R
import com.hammer.shopflow.ui.theme.DarkGrey
import com.hammer.shopflow.ui.theme.tintGreen
import kotlin.io.path.Path
import kotlin.io.path.moveTo

@Preview(showBackground = true)
@Composable
fun DiscountBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
        //.background(Color.Black, shape = RoundedCornerShape(16.dp))

    ) {
        Image(
            painter = painterResource(R.drawable.banner_card),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(36.dp)
                .padding(start = 18.dp)
        ) {
            Text("GET 20% OFF", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("Get 20% off", color = Color.LightGray)
            Spacer(Modifier.height(16.dp))
            Card(shape = RoundedCornerShape(24.dp)) {
                Text(
                    "12-16 October", modifier = Modifier
                        .background(tintGreen, shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

        }

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom)
        {
            Row(
                modifier = Modifier.width(200.dp).padding(start = 54.dp),
                verticalAlignment = Alignment.Bottom
            )
            {
                var bgColor = tintGreen
                for (i in 1..3) {
                    if (i > 1) bgColor = Color.Black
                    Spacer(
                        modifier = Modifier
                            .width(20.dp)
                            .height(4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                bgColor
                            )
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
        }
    }}

