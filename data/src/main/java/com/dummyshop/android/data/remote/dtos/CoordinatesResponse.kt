package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesResponse(
    val lat: Double,
    val lng: Double,
)
