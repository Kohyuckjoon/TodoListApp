package com.example.myapplication.repository

import com.example.myapplication.data.dao.ContentDao
import com.example.myapplication.model.ContentEntity
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val contentDao: ContentDao) : ContentRepository{

    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }
}