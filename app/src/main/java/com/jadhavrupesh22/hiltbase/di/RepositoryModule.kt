package com.jadhavrupesh22.hiltbase.di

import com.jadhavrupesh22.hiltbase.repo.MainRepository
import com.jadhavrupesh22.hiltbase.retrofit.AlbumService
import com.jadhavrupesh22.hiltbase.retrofit.JsonPlaceholderApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        jsonPlaceholderApi: JsonPlaceholderApi,
        albumService: AlbumService
    ): MainRepository {
        return MainRepository(jsonPlaceholderApi,albumService)
    }

}