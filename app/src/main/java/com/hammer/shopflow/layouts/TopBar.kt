package com.hammer.shopflow.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hammer.shopflow.ui.theme.DarkGrey
import com.hammer.shopflow.ui.theme.tintGreen

@Preview(showBackground = true)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkGrey)
            .padding(16.dp)
            .padding(top = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            Spacer(modifier = Modifier.padding(8.dp))
            Text("Shop", fontSize = 22.sp, color = Color.White)
        }

        Row {
            Icon(Icons.Default.Search, contentDescription = null, tint = Color.White)
            Spacer(Modifier.width(8.dp))
            Box {
                BadgedBox(
                    badge = {
                       Badge(
                           containerColor = tintGreen,
                           contentColor = Color.White,
                           content = {
                               Text(text = "5")
                           },
                           modifier = Modifier.offset(x = (-6).dp,y = (12).dp)
                       )
                    }
                ) {
                    Icon(modifier = Modifier.size(26.dp), imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.White)
                }
            }

            Spacer(Modifier.width(12.dp))
            Box {
                BadgedBox(
                    badge = {
                        Badge(
                            containerColor = tintGreen,
                            contentColor = Color.White,
                            content = {
                                Text(text = "3")
                            },
                            modifier = Modifier.offset(x = (0).dp,y = (12).dp)
                        )
                    }
                ) {
                    Icon(modifier = Modifier.size(26.dp), imageVector = Icons.Default.ShoppingCart, contentDescription = null, tint = Color.White)
                }
            }
        }
    }
}