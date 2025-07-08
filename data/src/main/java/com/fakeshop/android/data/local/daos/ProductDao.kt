package com.fakeshop.android.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fakeshop.android.data.local.entities.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM products WHERE whishlisted = 1")
    suspend fun getWhishlist(): List<ProductEntity>

    @Insert
    suspend fun insertAll(vararg products: ProductEntity)

    @Delete
    suspend fun delete(product: ProductEntity)
}