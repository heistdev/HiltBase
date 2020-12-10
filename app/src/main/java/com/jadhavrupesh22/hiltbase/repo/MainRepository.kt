package com.jadhavrupesh22.hiltbase.repo


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jadhavrupesh22.hiltbase.model.Post

import com.jadhavrupesh22.hiltbase.retrofit.AlbumService
import com.jadhavrupesh22.hiltbase.retrofit.JsonPlaceholderApi
import com.jadhavrupesh22.hiltbase.retrofit.PostNetworkEntity
import com.jadhavrupesh22.hiltbase.util.NetworkResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.ResponseBody
import retrofit2.Response


class MainRepository
constructor(
    val jsonPlaceholderApi: JsonPlaceholderApi,
    val albumService: AlbumService
) {

    fun getPost(): Flow<List<Post>> = flow {
        val response = jsonPlaceholderApi.getPosts()
        emit(response)
    }.flowOn(Dispatchers.IO)


}



