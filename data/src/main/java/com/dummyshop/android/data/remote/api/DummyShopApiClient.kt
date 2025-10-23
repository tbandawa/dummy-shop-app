package com.dummyshop.android.data.remote.api

import com.dummyshop.android.data.remote.dtos.CartResponse
import com.dummyshop.android.data.remote.dtos.CategoryResponse
import com.dummyshop.android.data.remote.dtos.LoginRequest
import com.dummyshop.android.data.remote.dtos.LoginResponse
import com.dummyshop.android.data.remote.dtos.ProductResponse
import com.dummyshop.android.data.remote.dtos.ProductsResponse
import com.dummyshop.android.data.remote.dtos.ProfileResponse
import com.dummyshop.android.data.remote.dtos.RefreshRequest
import com.dummyshop.android.data.remote.dtos.RefreshResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class DummyShopApiClient(httpClientEngine: HttpClientEngine) {

    companion object Companion {
        const val BASE_URL = "https://dummyjson.com"
    }

    val httpClient = HttpClient(httpClientEngine) {
        expectSuccess = true
        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun loginUser(username: String, password: String): LoginResponse {
        return httpClient.post {
            url("${BASE_URL}/auth/login")
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(username, password))
        }.body()
    }

    suspend fun getProfile(accessToken: String): ProfileResponse {
        return httpClient.get {
            url("${BASE_URL}/auth/me")
            headers {
                append(HttpHeaders.Authorization, accessToken)
            }
        }.body()
    }

    suspend fun refreshToken(refreshToken: String, expiresIn: Int): RefreshResponse {
        return httpClient.post {
            url("${BASE_URL}/auth/refresh")
            contentType(ContentType.Application.Json)
            setBody(RefreshRequest(refreshToken, expiresIn))
        }.body()
    }

    suspend fun getProducts(limit: Int = 0): ProductsResponse {
        return httpClient.get {
            url("${BASE_URL}/products")
            parameter("limit", limit)
        }.body()
    }

    suspend fun getProduct(id: Int): ProductResponse {
        return httpClient.get {
            url("${BASE_URL}/products/$id")
        }.body()
    }

    suspend fun searchProducts(query: String, limit: Int = 0): ProductsResponse {
        return httpClient.get {
            url("${BASE_URL}/products/search")
            parameter("q", query)
            parameter("limit", limit)
        }.body()
    }

    suspend fun getCategories(): List<CategoryResponse> {
        return httpClient.get {
            url("${BASE_URL}/products/categories")
        }.body()
    }

    suspend fun getProductsByCategory(category: String, limit: Int = 0): ProductsResponse {
        return httpClient.get {
            url("${BASE_URL}/products/category/$category")
            parameter("limit", limit)
        }.body()
    }

    suspend fun getCart(id: Int): CartResponse {
        return httpClient.get {
            url("${BASE_URL}/carts/$id")
        }.body()
    }
}
