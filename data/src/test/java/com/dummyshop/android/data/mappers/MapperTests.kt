package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.base.BaseUnitTest
import com.dummyshop.android.data.remote.dtos.CartResponse
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MapperTests: BaseUnitTest() {

    @Test
    fun `cart response mapper`() {
        val cartResponse = readJsonResponse<CartResponse>("cart_response.json")
        val cart = cartMapper.map(cartResponse)
        assertThat(cart.discountedTotal, `is`(89686.65))
        assertThat(cart.products.size, `is`(4))
    }
}