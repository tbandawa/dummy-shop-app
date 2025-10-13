package com.dummyshop.android.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dummyshop.android.data.local.daos.ProductDao
import com.dummyshop.android.data.local.daos.ProfileDao
import com.dummyshop.android.data.local.entities.ProductEntity
import com.dummyshop.android.data.local.entities.ProfileEntity

@Database(entities = [ProfileEntity::class, ProductEntity::class], version = 1)
abstract class DummyShopDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun productDao(): ProductDao
}