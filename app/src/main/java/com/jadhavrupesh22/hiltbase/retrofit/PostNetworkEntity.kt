package com.jadhavrupesh22.hiltbase.retrofit

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

data class PostNetworkEntity(

        @Expose
        val id: Int,

        @Expose
        val body: String,

        @Expose
        val title: String,

        @Expose
        val userId: Int
)