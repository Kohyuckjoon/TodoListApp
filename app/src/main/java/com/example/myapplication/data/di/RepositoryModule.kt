package com.example.myapplication.data.di

import com.example.myapplication.data.dao.ContentDao
import com.example.myapplication.repository.ContentRepository
import com.example.myapplication.repository.ContentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(contentDao: ContentDao) : ContentRepository = ContentRepositoryImpl(contentDao)
}