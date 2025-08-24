package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.myapplication.model.ContentEntity

@Dao
interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ContentEntity)

}