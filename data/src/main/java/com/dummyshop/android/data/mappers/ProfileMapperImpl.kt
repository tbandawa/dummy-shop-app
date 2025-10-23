package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.ProfileResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Address
import com.dummyshop.android.domain.models.Bank
import com.dummyshop.android.domain.models.Company
import com.dummyshop.android.domain.models.Coordinates
import com.dummyshop.android.domain.models.Crypto
import com.dummyshop.android.domain.models.Hair
import com.dummyshop.android.domain.models.Profile

class ProfileMapperImpl: Mapper<ProfileResponse, Profile> {

    override fun map(from: ProfileResponse): Profile {
        return Profile(
            id = from.id,
            firstName = from.firstName,
            lastName = from.lastName,
            maidenName = from.maidenName,
            age = from.age,
            gender = from.gender,
            email = from.email,
            phone = from.phone,
            username = from.username,
            password = from.password,
            birthDate = from.birthDate,
            image = from.image,
            bloodGroup = from.bloodGroup,
            height = from.height,
            weight = from.weight,
            eyeColor = from.eyeColor,
            hair = Hair(
                color = from.hair.color,
                type = from.hair.type
            ),
            ip = from.ip,
            address = Address(
                address = from.address.address,
                city = from.address.city,
                state = from.address.state,
                stateCode = from.address.stateCode,
                postalCode = from.address.postalCode,
                coordinates = Coordinates(
                    lat = from.address.coordinates.lat,
                    lng = from.address.coordinates.lng
                ),
                country = from.address.country
            ),
            macAddress = from.macAddress,
            university = from.university,
            bank = Bank(
                cardExpire = from.bank.cardExpire,
                cardNumber = from.bank.cardNumber,
                cardType = from.bank.cardType,
                currency = from.bank.currency,
                iban = from.bank.iban
            ),
            company = Company(
                department = from.company.department,
                name = from.company.name,
                title = from.company.title,
                address = Address(
                    address = from.company.address.address,
                    city = from.company.address.city,
                    state = from.company.address.state,
                    stateCode = from.company.address.stateCode,
                    postalCode = from.company.address.postalCode,
                    coordinates = Coordinates(
                        lat = from.company.address.coordinates.lat,
                        lng = from.company.address.coordinates.lng
                    ),
                    country = from.company.address.country
                )
            ),
            ein = from.ein,
            ssn = from.ssn,
            userAgent = from.userAgent,
            crypto = Crypto(
                coin = from.crypto.coin,
                wallet = from.crypto.wallet,
                network = from.crypto.network
            ),
            role = from.role
        )
    }
}