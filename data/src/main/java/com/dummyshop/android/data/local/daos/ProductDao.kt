package com.dummyshop.android.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dummyshop.android.data.local.entities.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM products WHERE isWishlist = 0")
    fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE isWishlist = 1")
    fun getWishlist(): List<ProductEntity>

    @Insert
    fun insertAll(vararg products: ProductEntity)

    @Insert
    suspend fun addWishlist(product: ProductEntity)

    @Query("UPDATE products SET isWishlist = 0 WHERE id = :productId")
    fun removeFromWishList(productId: Long)

    @Query("DELETE FROM products WHERE isWishlist = 1")
    fun clearWishlist()

    @Query("DELETE FROM products WHERE isWishlist = 0")
    fun clearProducts()
}
