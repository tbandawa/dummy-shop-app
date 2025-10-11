package com.dummyshop.android.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "whishlisted") val wishlisted: Boolean
)