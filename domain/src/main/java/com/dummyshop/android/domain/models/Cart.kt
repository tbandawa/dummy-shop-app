package com.dummyshop.android.domain.models

data class Cart(
    val id: Long,
    val products: List<CartProduct>,
    val total: Double,
    val discountedTotal: Double,
    val userId: Long,
    val totalProducts: Long,
    val totalQuantity: Long,
)
