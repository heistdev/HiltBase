package com.jadhavrupesh22.hiltbase.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jadhavrupesh22.hiltbase.repo.MainRepository
import com.jadhavrupesh22.hiltbase.model.Post
import com.jadhavrupesh22.hiltbase.util.NetworkResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel
@ViewModelInject
constructor(val mainRepository: MainRepository) : ViewModel() {
    val _postLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postLiveData: LiveData<List<Post>>
        get() = _postLiveData


    fun getPost() {
        viewModelScope.launch {
            delay(1000)
            mainRepository.getPost()
                .catch { e ->
                    Log.d("main", "getPost: ${e.message}")
                }.collect { response ->
                    _postLiveData.value = response
                }


        }
    }


}