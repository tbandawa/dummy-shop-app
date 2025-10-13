package com.dummyshop.android.data.remote

import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.dummyshop.android.data.local.daos.ProductDao
import com.dummyshop.android.data.local.daos.ProfileDao
import com.dummyshop.android.data.local.db.DummyShopDatabase
import com.dummyshop.android.data.local.entities.ProductEntity
import com.dummyshop.android.data.local.entities.ProfileEntity
import kotlinx.coroutines.runBlocking
import kotlinx.io.IOException
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.UUID

@RunWith(AndroidJUnit4::class)
class DummyShopDatabaseTests {

    private lateinit var profileDao: ProfileDao

    private lateinit var productDao: ProductDao

    private lateinit var database: DummyShopDatabase

    @Before
    fun createDb() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(
            appContext, DummyShopDatabase::class.java).build()
        profileDao = database.profileDao()
        productDao = database.productDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeProductsAndReadInList() {
        val exampleProduct = ProductEntity(
            uid = UUID.randomUUID(),
            id = 101L,
            title = "Ergonomic Mechanical Keyboard",
            description = "A split, tented mechanical keyboard with brown tactile switches.",
            category = "Electronics",
            price = 149.99,
            discountPercentage = 10.0,
            rating = 4.7,
            thumbnail = "https://example.com/images/keyboard_thumb.jpg",
            isWishlist = true
        )
        val anotherProduct = ProductEntity(
            uid = UUID.randomUUID(),
            id = 205L,
            title = "The Kotlin Programming Guide",
            description = "A comprehensive book covering all modern Kotlin features, from basics to coroutines.",
            category = "Books",
            price = 35.50,
            discountPercentage = 0.0,
            rating = 4.9,
            thumbnail = "https://example.com/images/kotlin_book.jpg",
            isWishlist = false
        )
        val discountedProduct = ProductEntity(
            uid = UUID.randomUUID(),
            id = 312L,
            title = "Organic Cotton T-Shirt",
            description = "Sustainable and comfortable white cotton t-shirt for everyday wear.",
            category = "Apparel",
            price = 25.00,
            discountPercentage = 25.0,
            rating = 4.2,
            thumbnail = "https://example.com/images/tshirt.jpg",
            isWishlist = true
        )
        productDao.insertAll(exampleProduct, anotherProduct, discountedProduct)
        assertThat(productDao.getProducts().size, equalTo(1))
        assertThat(productDao.getWishlist().size, equalTo(2))
        productDao.clearProducts()
        productDao.clearWishlist()
        assertThat(productDao.getProducts().size, equalTo(0))
        assertThat(productDao.getWishlist().size, equalTo(0))
    }

    @Test
    @Throws(Exception::class)
    fun writeSingleProductAndRead() {
        val exampleProduct = ProductEntity(
            uid = UUID.randomUUID(),
            id = 101L,
            title = "Ergonomic Mechanical Keyboard",
            description = "A split, tented mechanical keyboard with brown tactile switches.",
            category = "Electronics",
            price = 149.99,
            discountPercentage = 10.0,
            rating = 4.7,
            thumbnail = "https://example.com/images/keyboard_thumb.jpg",
            isWishlist = true
        )
        runBlocking {
            productDao.addWishlist(exampleProduct)
            assertThat(productDao.getWishlist().size, equalTo(1))
            productDao.removeFromWishList(101L)
            assertThat(productDao.getWishlist().size, equalTo(0))
        }
    }

    @Test
    @Throws(Exception::class)
    fun writeSingleProfileAndRead() {
        val userProfile = ProfileEntity(
            uid = UUID.randomUUID(),
            id = 5001L,
            firstName = "Alex",
            lastName = "Johnson",
            gender = "Male",
            email = "alex.j@example.com",
            image = "https://cdn.images.com/profiles/alex_j.jpg",
            accessToken = "kjh34g5j34k5hg6kjh34kj5h3g4k5jhg34", // Dummy token
            refreshToken = "l2k3j4h5g6k3j4h5g6k3j4h5g6k3j4h5g6" // Dummy token
        )
        runBlocking {
            profileDao.saveProfile(userProfile)
            assertThat(profileDao.getProfile()?.id, equalTo(5001))
            profileDao.clearProfile()
            assertThat(profileDao.getProfile(), equalTo(null))
        }
    }
}