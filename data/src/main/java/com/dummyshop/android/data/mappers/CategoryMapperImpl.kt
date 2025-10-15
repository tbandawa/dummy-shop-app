package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.remote.dtos.CategoryResponse
import com.dummyshop.android.domain.mappers.Mapper
import com.dummyshop.android.domain.models.Category

class CategoryMapperImpl: Mapper<CategoryResponse, Category> {

    override fun map(from: CategoryResponse): Category {
        TODO("Not yet implemented")
    }
}

fun CategoryMapperImpl.mapAll(list: List<CategoryResponse>) = list.map { map(it) }
