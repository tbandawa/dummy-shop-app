package com.dummyshop.android.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val maidenName: String,
    val age: Long,
    val gender: String,
    val email: String,
    val phone: String,
    val username: String,
    val password: String,
    val birthDate: String,
    val image: String,
    val bloodGroup: String,
    val height: Double,
    val weight: Double,
    val eyeColor: String,
    val hair: HairResponse,
    val ip: String,
    val address: AddressResponse,
    val macAddress: String,
    val university: String,
    val bank: BankResponse,
    val company: CompanyResponse,
    val ein: String,
    val ssn: String,
    val userAgent: String,
    val crypto: CryptoResponse,
    val role: String,
)
