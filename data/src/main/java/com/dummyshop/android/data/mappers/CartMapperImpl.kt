package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.CartResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Cart
import com.dummyshop.android.domain.models.CartProduct

class CartMapperImpl: Mapper<CartResponse, Cart> {

    override fun map(from: CartResponse): Cart {
        return Cart(
            id = from.id,
            products = from.products.map {
                CartProduct(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    quantity = it.quantity,
                    total = it.total,
                    discountPercentage = it.discountPercentage,
                    discountedTotal = it.discountedTotal,
                    thumbnail = it.thumbnail
                )
            },
            total = from.total,
            discountedTotal = from.discountedTotal,
            userId = from.userId,
            totalProducts = from.totalProducts,
            totalQuantity = from.totalQuantity
        )
    }
}