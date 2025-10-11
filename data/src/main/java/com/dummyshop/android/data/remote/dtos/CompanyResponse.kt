package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CompanyResponse(
    val department: String,
    val name: String,
    val title: String,
    val address: AddressResponse,
)
