package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class HairResponse(
    val color: String,
    val type: String,
)
