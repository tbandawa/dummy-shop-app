package com.dummyshop.android.domain.models


data class Products(
    val products: List<Product>,
    val total: Long,
    val skip: Long,
    val limit: Long,
)
