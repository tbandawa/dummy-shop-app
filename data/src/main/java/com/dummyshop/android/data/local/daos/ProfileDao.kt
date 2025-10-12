package com.dummyshop.android.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dummyshop.android.data.local.entities.ProfileEntity

@Dao
interface ProfileDao {

    @Insert
    suspend fun saveProfile(profile: ProfileEntity)

    @Query("SELECT * FROM profile LIMIT 1")
    suspend fun getProfile(): ProfileEntity?

    @Query("DELETE FROM profile")
    suspend fun clearProfile()
}