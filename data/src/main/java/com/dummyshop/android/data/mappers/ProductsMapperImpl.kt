package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.ProductsResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Dimensions
import com.dummyshop.android.domain.models.Meta
import com.dummyshop.android.domain.models.Product
import com.dummyshop.android.domain.models.Products
import com.dummyshop.android.domain.models.Review

class ProductsMapperImpl: Mapper<ProductsResponse, Products> {

    override fun map(from: ProductsResponse): Products {
        return Products(
            products = from.products.map {
                Product(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    category = it.category,
                    price = it.price,
                    discountPercentage = it.discountPercentage,
                    rating = it.rating,
                    stock = it.stock,
                    tags = it.tags.map{ it },
                    brand = it.brand,
                    sku = it.sku,
                    weight = it.weight,
                    dimensions = Dimensions(
                        width = it.dimensions.width,
                        height = it.dimensions.height,
                        depth = it.dimensions.depth
                    ),
                    warrantyInformation = it.warrantyInformation,
                    shippingInformation = it.shippingInformation,
                    availabilityStatus = it.availabilityStatus,
                    reviews = it.reviews.map {
                        Review(
                            rating = it.rating,
                            comment = it.comment,
                            date = it.date,
                            reviewerName = it.reviewerName,
                            reviewerEmail = it.reviewerEmail
                        )
                    },
                    returnPolicy = it.returnPolicy,
                    minimumOrderQuantity = it.minimumOrderQuantity,
                    meta = Meta(
                        createdAt = it.meta.createdAt,
                        updatedAt = it.meta.updatedAt,
                        barcode = it.meta.barcode,
                        qrCode = it.meta.qrCode
                    ),
                    images = it.images.map { it },
                    thumbnail = it.thumbnail
                )
            },
            total = from.total,
            skip = from.skip,
            limit = from.limit
        )
    }
}