package com.hammer.shopflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hammer.shopflow.layouts.CategorySection
import com.hammer.shopflow.layouts.DiscountBanner
import com.hammer.shopflow.layouts.ProductDescriptionLayout
import com.hammer.shopflow.layouts.ProductLayout
import com.hammer.shopflow.layouts.TopBar
import com.hammer.shopflow.ui.theme.DarkGrey
import com.hammer.shopflow.ui.theme.ShopFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopFlowTheme {
                Scaffold(topBar = { TopBar(modifier = Modifier) },modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.verticalScroll(rememberScrollState()).padding(innerPadding).fillMaxWidth().background(
                        DarkGrey)) {
                        DiscountBanner()
                        CategorySection()
                        ProductLayout()
                    }

                }
            }
        }
    }
}

