package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val id: Long,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val tags: List<String>,
    val brand: String?,
    val sku: String,
    val weight: Long,
    val dimensions: DimensionsResponsible,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<ReviewResponse>,
    val returnPolicy: String,
    val minimumOrderQuantity: Long,
    val meta: MetaResponse,
    val images: List<String>,
    val thumbnail: String,
)
