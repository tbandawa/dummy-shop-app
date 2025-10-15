package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.CartResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Cart

class CartMapperImpl: Mapper<CartResponse, Cart> {

    override fun map(from: CartResponse): Cart {
        TODO("Not yet implemented")
    }
}