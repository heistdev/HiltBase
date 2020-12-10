package com.jadhavrupesh22.hiltbase.model

import com.google.gson.annotations.Expose

data class Post(
    @Expose
    val body: String,
    @Expose
    val id: Int,
    @Expose
    val title: String,
    @Expose
    val userId: Int
)