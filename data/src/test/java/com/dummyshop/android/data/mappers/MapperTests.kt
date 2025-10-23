package com.dummyshop.android.data.mappers

import com.dummyshop.android.data.base.BaseUnitTest
import com.dummyshop.android.data.remote.dtos.CartResponse
import com.dummyshop.android.data.remote.dtos.CategoryResponse
import com.dummyshop.android.data.remote.dtos.LoginResponse
import com.dummyshop.android.data.remote.dtos.ProductResponse
import com.dummyshop.android.data.remote.dtos.ProductsResponse
import com.dummyshop.android.data.remote.dtos.ProfileResponse
import com.dummyshop.android.data.remote.dtos.RefreshResponse
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MapperTests: BaseUnitTest() {

    @Test
    fun `test login mapper`() {
        val loginResponse = readJsonResponse<LoginResponse>("login_response.json")
        val login = loginMapper.map(loginResponse)
        assertThat(login.id, `is`(1))
        assertThat(login.lastName, `is`("Johnson"))

    }

    @Test
    fun `test refresh mapper`() {
        val refreshResponse = readJsonResponse<RefreshResponse>("token_response.json")
        val refresh = refreshMapper.map(refreshResponse)
        assertThat(refresh.accessToken.substring(0, 2), `is`("ey"))
    }

    @Test
    fun `test profile mapper`() {
        val profileResponse = readJsonResponse<ProfileResponse>("profile_response.json")
        val profile = profileMapper.map(profileResponse)
        assertThat(profile.id, `is`(1))
        assertThat(profile.lastName, `is`("Johnson"))
    }

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
    fun `test product mapper`() {
        val productResponse = readJsonResponse<ProductResponse>("product_response.json")
        val product = productsMapper.mapProduct(productResponse)
        assertThat(product.id, `is`(1L))
    }

    @Test
    fun `test categories mapper`() {
        val categoriesResponse = readJsonResponse<List<CategoryResponse>>("categories_response.json")
        val categories = categoryMapper.mapAll(categoriesResponse)
        assertThat(categories.size, `is`(24))
    }
}