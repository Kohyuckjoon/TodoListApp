package com.example.myapplication.repository

import com.example.myapplication.model.ContentEntity

interface ContentRepository {

    suspend fun insert(item: ContentEntity)
}