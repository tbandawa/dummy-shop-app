package com.fakeshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class AddressResponse(
    val address: String,
    val city: String,
    val state: String,
    val stateCode: String,
    val postalCode: String,
    val coordinates: CoordinatesResponse,
    val country: String,
)
