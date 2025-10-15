package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.ProductsResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Products

class ProductsMapperImpl: Mapper<ProductsResponse, Products> {
    
    override fun map(from: ProductsResponse): Products {
        TODO("Not yet implemented")
    }
}