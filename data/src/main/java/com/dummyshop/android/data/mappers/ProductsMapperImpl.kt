package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.ProductResponse
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
                mapProduct(it)
            },
            total = from.total,
            skip = from.skip,
            limit = from.limit
        )
    }

    fun mapProduct(response: ProductResponse): Product {
        return Product(
            id = response.id,
            title = response.title,
            description = response.description,
            category = response.category,
            price = response.price,
            discountPercentage = response.discountPercentage,
            rating = response.rating,
            stock = response.stock,
            tags = response.tags.map{ it },
            brand = response.brand,
            sku = response.sku,
            weight = response.weight,
            dimensions = Dimensions(
                width = response.dimensions.width,
                height = response.dimensions.height,
                depth = response.dimensions.depth
            ),
            warrantyInformation = response.warrantyInformation,
            shippingInformation = response.shippingInformation,
            availabilityStatus = response.availabilityStatus,
            reviews = response.reviews.map {
                Review(
                    rating = it.rating,
                    comment = it.comment,
                    date = it.date,
                    reviewerName = it.reviewerName,
                    reviewerEmail = it.reviewerEmail
                )
            },
            returnPolicy = response.returnPolicy,
            minimumOrderQuantity = response.minimumOrderQuantity,
            meta = Meta(
                createdAt = response.meta.createdAt,
                updatedAt = response.meta.updatedAt,
                barcode = response.meta.barcode,
                qrCode = response.meta.qrCode
            ),
            images = response.images.map { it },
            thumbnail = response.thumbnail
        )
    }
}