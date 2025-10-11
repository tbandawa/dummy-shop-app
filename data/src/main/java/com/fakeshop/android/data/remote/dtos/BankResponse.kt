package com.fakeshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class BankResponse(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String,
)
