package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    val rating: Long,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String,
)
