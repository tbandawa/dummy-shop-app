package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.ProfileResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Profile

class ProfileMapperImpl: Mapper<ProfileResponse, Profile> {

    override fun map(from: ProfileResponse): Profile {
        TODO("Not yet implemented")
    }
}