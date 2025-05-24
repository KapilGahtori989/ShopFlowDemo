package com.hammer.shopflow.layouts

import android.media.Rating
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hammer.shopflow.Models.ProductModel
import com.hammer.shopflow.R
import com.hammer.shopflow.ui.theme.Purple40
import com.hammer.shopflow.ui.theme.tintGreen
import com.hammer.shopflow.ui.theme.tintPurple
import com.hammer.shopflow.ui.theme.titleFontFamily
import com.hammer.shopflow.ui.theme.titleFontFamily1

//@Preview(showBackground = true)
@Composable
fun ProductDescriptionLayout(title:String,currentRating: Int, onRatingChanged: (Int) -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        //Background Image
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.card_black_shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Text(
            modifier = Modifier.padding(start = 16.dp,bottom = 8.dp,top = 4.dp),
            text = title,
            color = tintGreen,
            fontSize = 36.sp,
            fontFamily = titleFontFamily1,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 16.dp, end = 16.dp, top = 4.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().height(36.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom
            ) {
                Text("  •  In Stock", color = tintGreen, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.size(2.dp))
            Text(
                "French clay and algae-powered cleanser",
                maxLines = 1,
                color = Color.White,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.size(2.dp))
            Text(
                modifier = Modifier.padding(end = 40.dp),
                maxLines = 1,
                text = "Skin Tightness • Dry & Dehydrated Skin",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.size(2.dp))
            Row {
                Text(
                    "Rs. 355.20",
                    color = tintPurple,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    "Rs. 444.00",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.LineThrough
                )
            }
            Spacer(modifier = Modifier.size(2.dp))
            Row(
                modifier = Modifier.padding(end = 44.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                StarRatingBar(rating = currentRating, onRatingChanged = { onRatingChanged(it) })
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    "249 reviews",
                    fontSize = 10.sp,
                    maxLines = 1,
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                )
            }

        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 8.dp,end = 0.dp)
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Cart()
        }
    }
}

@Composable
fun StarRatingBar(
    modifier: Modifier = Modifier,
    rating: Int = 5,
    onRatingChanged: (Int) -> Unit
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(1.dp)) {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = "Star $i",
                tint = if (i <= rating) Color(0xFFFFD700) else Color.Gray,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onRatingChanged(i) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Cart(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .size(50.dp)
            .padding(2.dp)
           , border = BorderStroke(
            1.dp,
            tintGreen
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(40.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().background(Color.Transparent).padding(top = 12.dp),
            contentAlignment = Alignment.Center
        ) {
//            Image(
//                modifier = Modifier.width(20.dp).height(20.dp),
//                painter = painterResource(R.drawable.cart3),
//                contentDescription = null,
//                contentScale = ContentScale.FillBounds
//            )
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = null,
                tint = tintGreen
            )
        }
    }
}