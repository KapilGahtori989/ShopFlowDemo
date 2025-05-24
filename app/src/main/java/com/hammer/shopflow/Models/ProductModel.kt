package com.hammer.shopflow.Models

data class ProductModel(
    val id:Int,
    val imageId:Int,
    val title:String,
    var rating:Int,
    var favourite:Boolean
)
