package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.base.BaseUnitTest
import com.dummyshop.android.data.remote.dtos.CartResponse
import com.dummyshop.android.data.remote.dtos.CategoryResponse
import com.dummyshop.android.data.remote.dtos.ProductsResponse
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MapperTests: BaseUnitTest() {

    @Test
    fun `test cart mapper`() {
        val cartResponse = readJsonResponse<CartResponse>("cart_response.json")
        val cart = cartMapper.map(cartResponse)
        assertThat(cart.discountedTotal, `is`(89686.65))
        assertThat(cart.products.size, `is`(4))
    }

    @Test
    fun `test products mapper`() {
        val productsResponse = readJsonResponse<ProductsResponse>("products_response.json")
        val products = productsMapper.map(productsResponse)
        assertThat(products.total, `is`(194L))
        assertThat(products.products.size, `is`(30))
    }

    @Test
    fun `test categories mapper`() {
        val categoriesResponse = readJsonResponse<List<CategoryResponse>>("categories_response.json")
        val categories = categoryMapper.mapAll(categoriesResponse)
        assertThat(categories.size, `is`(194L))
    }
}