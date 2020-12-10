package com.jadhavrupesh22.hiltbase.retrofit

import com.jadhavrupesh22.hiltbase.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("posts")
    suspend fun getPosts() : List<Post>

}