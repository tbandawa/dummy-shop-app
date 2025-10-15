package com.dummyshop.android.domain.models

data class Refresh(
    val accessToken: String,
    val refreshToken: String,
)
