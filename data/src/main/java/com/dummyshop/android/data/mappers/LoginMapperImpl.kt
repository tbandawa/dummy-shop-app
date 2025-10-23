package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.LoginResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Login

class LoginMapperImpl: Mapper<LoginResponse, Login> {

    override fun map(from: LoginResponse): Login {
        return Login(
            accessToken = from.accessToken,
            refreshToken = from.refreshToken,
            id = from.id,
            username = from.username,
            email = from.email,
            firstName = from.firstName,
            lastName = from.lastName,
            gender = from.gender,
            image = from.image
        )
    }
}