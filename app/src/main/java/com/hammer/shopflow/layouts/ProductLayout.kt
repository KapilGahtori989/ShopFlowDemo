package com.hammer.shopflow.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hammer.shopflow.Models.ProductModel
import com.hammer.shopflow.ProductViewModel
import com.hammer.shopflow.R
import com.hammer.shopflow.ui.theme.tintGreen
import com.hammer.shopflow.ui.theme.tintPurple

//@Preview(showBackground = true)
@Composable
fun ProductLayout(modifier: Modifier = Modifier) {
    val productViewModel: ProductViewModel = viewModel()
    val productData = productViewModel.products.collectAsState()
    Column(
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "New Products",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "See All", color = Color.White, style = TextStyle(
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
            )
        }

        productData.value.forEach { it ->
            ProductCard(
                it,
                updateFavourite = { id, fav -> productViewModel.updateFavourite(id, fav) },
                updateRating = { id, rating -> productViewModel.updateRating(id, rating) })
            Spacer(modifier = Modifier.size(10.dp))
        }
//        LazyColumn(modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()) {
//            items(productData.value) {
//                ProductCard()
//                Spacer(modifier = Modifier.size(10.dp))
//            }
        //}
    }
}

@Composable
fun ProductCard(
    productModel: ProductModel,
    updateFavourite: (Int, Boolean) -> Unit,
    updateRating: (Int, Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp),
        contentAlignment = Alignment.TopCenter
    )
    {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.card_grey_bg_png),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 6.dp, bottom = 4.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            WishListHeart(onHeartClicked = {
                updateFavourite(
                    productModel.id,
                    !productModel.favourite
                )
            }, clicked = productModel.favourite)
            Card(
                modifier = Modifier.wrapContentWidth(), colors = CardDefaults.cardColors(
                    containerColor = Color.Black
                ), shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    fontSize = 12.sp,
                    text = "Best Seller",
                    color = tintGreen
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(productModel.imageId),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter
            )
            ProductDescriptionLayout(
                productModel.title,
                productModel.rating,
                onRatingChanged = { updateRating(productModel.id, it) },
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}

@Composable
fun WishListHeart(modifier: Modifier = Modifier, onHeartClicked: () -> Unit, clicked: Boolean) {
    LaunchedEffect(clicked) {
        println("Heart icon recomposed: $clicked")
    }

    Card(
        modifier = Modifier
            .size(45.dp)
            .padding(2.dp)
            .clickable(interactionSource = remember{ MutableInteractionSource() }, indication = null) {onHeartClicked() },
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        shape = RoundedCornerShape(50.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(top = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            if (clicked) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    tint = tintPurple
                )
            } else {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    tint = tintPurple
                )
            }

        }
    }
}