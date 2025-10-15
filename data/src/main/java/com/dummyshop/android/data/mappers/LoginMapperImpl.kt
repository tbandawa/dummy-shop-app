package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.LoginResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Login

class LoginMapperImpl: Mapper<LoginResponse, Login> {

    override fun map(from: LoginResponse): Login {
        TODO("Not yet implemented")
    }
}