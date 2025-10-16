package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.RefreshResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Refresh

class RefreshMapperImpl: Mapper<RefreshResponse, Refresh> {

    override fun map(from: RefreshResponse): Refresh {
        return Refresh(
            accessToken = from.accessToken,
            refreshToken = from.refreshToken
        )
    }
}