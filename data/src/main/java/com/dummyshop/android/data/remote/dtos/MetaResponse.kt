package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class MetaResponse(
    val createdAt: String,
    val updatedAt: String,
    val barcode: String,
    val qrCode: String,
)
