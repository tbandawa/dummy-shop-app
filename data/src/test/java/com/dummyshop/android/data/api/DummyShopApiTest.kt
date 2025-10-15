package com.dummyshop.android.data.api

import com.dummyshop.android.data.base.BaseUnitTest
import com.dummyshop.android.data.remote.api.DummyShopApiClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DummyShopApiTest: BaseUnitTest() {

    @Test
    fun `user login`() = runBlocking {
        enqueueResponse("login_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.loginUser("username", "password")
        assertThat(response.id, `is`(1))
    }

    @Test
    fun `user profile`() = runBlocking {
        enqueueResponse("profile_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.getProfile("token")
        assertThat(response.id, `is`(1))
        assertThat(response.username, `is`("emilys"))
    }

    @Test
    fun `refresh token`() = runBlocking {
        enqueueResponse("token_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.refreshToken("token", 60)
        assertThat(response.accessToken.substring(0, 1), `is`("e"))
    }

    @Test
    fun `get products`() = runBlocking {
        enqueueResponse("products_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.getProducts()
        assertThat(response.total, `is`(194))
    }

    @Test
    fun `get product`() = runBlocking {
        enqueueResponse("product_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.getProduct(1)
        assertThat(response.id, `is`(1))
    }

    @Test
    fun `search products`() = runBlocking {
        enqueueResponse("search_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.searchProducts("query")
        assertThat(response.total, `is`(23))
    }

    @Test
    fun `get categories`() = runBlocking {
        enqueueResponse("categories_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.getCategories()
        assertThat(response.size, `is`(24))
    }

    @Test
    fun `search products by vategory`() = runBlocking {
        enqueueResponse("category_products_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.getProductsByCategory("category")
        assertThat(response.total, `is`(16))
    }

    @Test
    fun `get cart`() = runBlocking {
        enqueueResponse("cart_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.getCart(1)
        assertThat(response.total, `is`(103774.85))
    }

    @Test
    fun `auth is failure`() {
        try {
            enqueueResponse("error_response.json", HttpStatusCode.Unauthorized)
            dummyShopApiClient = DummyShopApiClient(mockEngine)
            runBlocking {
                dummyShopApiClient.loginUser("username", "password")
            }
        } catch (e: ClientRequestException) {
            assertThat(e.response.status.value, `is`(401))
            assertThat(e.message, containsString("Invalid credentials"))
        }
    }
}