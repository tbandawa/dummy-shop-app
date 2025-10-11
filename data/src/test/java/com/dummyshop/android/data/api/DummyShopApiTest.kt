package com.dummyshop.android.data.api

import com.dummyshop.android.data.base.BaseTest
import com.dummyshop.android.data.remote.api.DummyShopApiClient
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DummyShopApiTest: BaseTest() {

    @Test
    fun `user login`() = runBlocking {
        enqueueResponse("login_response.json")
        dummyShopApiClient = DummyShopApiClient(mockEngine)
        val response = dummyShopApiClient.loginUser("username", "password")
        assertThat(response.id, `is`(1))
    }
}