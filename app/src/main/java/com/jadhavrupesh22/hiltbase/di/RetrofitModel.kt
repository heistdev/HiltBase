package com.jadhavrupesh22.hiltbase.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jadhavrupesh22.hiltbase.retrofit.AlbumService
import com.jadhavrupesh22.hiltbase.retrofit.JsonPlaceholderApi
import com.jadhavrupesh22.hiltbase.util.Common
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RetrofitModel {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }

    @Singleton
    @Provides
    fun providesRetrofit(gson: Gson): Retrofit =
            Retrofit.Builder()
                    .baseUrl(Common.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()


    @Singleton
    @Provides
    fun providePostService(retrofit: Retrofit): JsonPlaceholderApi {
        return retrofit
                .create(JsonPlaceholderApi::class.java)
    }


    @Singleton
    @Provides
    fun provideAlbumService(retrofit: Retrofit): AlbumService {
        return retrofit
            .create(AlbumService::class.java)
    }


}