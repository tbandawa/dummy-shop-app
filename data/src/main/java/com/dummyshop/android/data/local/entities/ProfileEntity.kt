package com.dummyshop.android.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey val uid: UUID,
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "accessToken") val accessToken: String,
    @ColumnInfo(name = "refreshToken") val refreshToken: String,
)