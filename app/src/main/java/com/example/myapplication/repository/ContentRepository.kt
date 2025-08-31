package com.example.myapplication.repository

import com.example.myapplication.model.ContentEntity
import kotlinx.coroutines.flow.Flow


interface ContentRepository {

    fun loadList() : Flow<List<ContentEntity>>

    suspend fun insert(item: ContentEntity)

    suspend fun modify(item: ContentEntity)

    suspend fun delete(item: ContentEntity)
}