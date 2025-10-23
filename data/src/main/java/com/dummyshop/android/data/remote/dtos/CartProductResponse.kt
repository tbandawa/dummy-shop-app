package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CartProductResponse(
    val id: Long,
    val title: String,
    val price: Double,
    val quantity: Long,
    val total: Double,
    val discountPercentage: Double,
    val discountedTotal: Double,
    val thumbnail: String,
)
