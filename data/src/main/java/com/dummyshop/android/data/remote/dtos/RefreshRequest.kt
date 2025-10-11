package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class RefreshRequest(
    val refreshToken: String,
    val expiresInMinutes: Int
)
