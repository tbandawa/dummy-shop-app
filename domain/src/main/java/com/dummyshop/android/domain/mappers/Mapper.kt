package com.dummyshop.android.domain.mappers

interface Mapper<in From, out To> {
    fun map(from: From): To
}