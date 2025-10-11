package com.fakeshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    val products: List<ProductResponse>,
    val total: Long,
    val skip: Long,
    val limit: Long,
)
