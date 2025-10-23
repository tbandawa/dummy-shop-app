package com.dummyshop.android.data.remote.base

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.dummyshop.android.data.local.daos.ProductDao
import com.dummyshop.android.data.local.daos.ProfileDao
import com.dummyshop.android.data.local.db.DummyShopDatabase
import kotlinx.io.IOException
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseInstrTest {

    protected lateinit var profileDao: ProfileDao

    protected lateinit var productDao: ProductDao

    protected lateinit var database: DummyShopDatabase

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
}