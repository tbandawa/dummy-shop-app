package com.dummyshop.android.domain.models

data class Review(
    val rating: Long,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String,
)
