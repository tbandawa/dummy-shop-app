package com.dummyshop.android.data.base

import com.dummyshop.android.data.mappers.CartMapperImpl
import com.dummyshop.android.data.mappers.CategoryMapperImpl
import com.dummyshop.android.data.mappers.LoginMapperImpl
import com.dummyshop.android.data.mappers.ProductsMapperImpl
import com.dummyshop.android.data.mappers.ProfileMapperImpl
import com.dummyshop.android.data.mappers.RefreshMapperImpl
import com.dummyshop.android.data.remote.api.DummyShopApiClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
abstract class BaseUnitTest {

    protected lateinit var loginMapper: LoginMapperImpl

    protected lateinit var refreshMapper: RefreshMapperImpl

    protected lateinit var profileMapper: ProfileMapperImpl

    protected lateinit var cartMapper: CartMapperImpl

    protected lateinit var categoryMapper: CategoryMapperImpl

    protected lateinit var productsMapper: ProductsMapperImpl

    protected lateinit var dummyShopApiClient: DummyShopApiClient

    protected lateinit var mockEngine: MockEngine

    @Before
    fun testsSetup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        loginMapper = LoginMapperImpl()
        refreshMapper = RefreshMapperImpl()
        profileMapper = ProfileMapperImpl()
        cartMapper = CartMapperImpl()
        categoryMapper = CategoryMapperImpl()
        productsMapper = ProductsMapperImpl()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    protected fun enqueueResponse(
        fileName: String,
        statusCode: HttpStatusCode = HttpStatusCode.OK
    ) {
        mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(this::class.java.classLoader!!.getResource(fileName).readText()),
                status = statusCode,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
    }

    protected inline fun <reified T : Any> readJsonResponse(fileName: String) : T {
        val fileContent = stringResponse(fileName)
        return Json.decodeFromString<T>(fileContent)
    }

    protected fun BaseUnitTest.stringResponse(fileName: String): String =
        this::class.java.classLoader!!.getResource(fileName).readText()
}