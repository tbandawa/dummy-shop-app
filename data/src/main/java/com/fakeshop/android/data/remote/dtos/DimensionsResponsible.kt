package com.fakeshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class DimensionsResponsible(
    val width: Double,
    val height: Double,
    val depth: Double,
)
