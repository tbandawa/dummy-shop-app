package com.fakeshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val slug: String,
    val name: String,
    val url: String,
)
