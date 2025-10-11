package com.fakeshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CryptoResponse(
    val coin: String,
    val wallet: String,
    val network: String,
)
