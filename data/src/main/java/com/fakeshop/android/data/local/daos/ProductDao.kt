package com.fakeshop.android.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fakeshop.android.data.local.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM products WHERE whishlisted = 1")
    fun getWhishlist(): Flow<List<ProductEntity>>

    @Insert
    suspend fun insert(product: ProductEntity)

    @Delete
    suspend fun delete(product: ProductEntity)
}