package com.dummyshop.android.domain.models

data class CartProduct(
    val id: Long,
    val title: String,
    val price: Double,
    val quantity: Long,
    val total: Double,
    val discountPercentage: Double,
    val discountedTotal: Double,
    val thumbnail: String,
)
