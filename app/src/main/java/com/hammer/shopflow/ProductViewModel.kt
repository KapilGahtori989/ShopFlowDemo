package com.hammer.shopflow

import androidx.lifecycle.ViewModel
import com.hammer.shopflow.Models.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductViewModel:ViewModel(){
    var productList: MutableList<ProductModel> = mutableListOf(
        ProductModel(1, imageId = R.drawable.product_image,"clencera", 5, false),
        ProductModel(2,imageId = R.drawable.categorysample, "glow", 3, true),
        ProductModel(3, imageId = R.drawable.product_image,"afterGlow", 5, true),
        )

    private var _productsFlow = MutableStateFlow<List<ProductModel>>(
        productList
    )
    val products:StateFlow<List<ProductModel>> = _productsFlow.asStateFlow()

    fun updateRating(productId: Int, newRating: Int){
        val updatedList = _productsFlow.value.map { product ->
            if (product.id == productId) product.copy(rating = newRating) else product
        }
        _productsFlow.value = updatedList
    }

    fun updateFavourite(productId: Int, newFavourite: Boolean) {
        println("Updating product $productId to favourite = $newFavourite")
        val updatedList = _productsFlow.value.map { product ->
            if (product.id == productId) product.copy(favourite = newFavourite) else product
        }
        _productsFlow.value = updatedList

    }
}