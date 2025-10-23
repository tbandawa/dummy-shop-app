package com.dummyshop.android.domain.models

data class Login(
    val accessToken: String,
    val refreshToken: String,
    val id: Long,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
)
