package com.jadhavrupesh22.hiltbase.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jadhavrupesh22.hiltbase.R
import com.jadhavrupesh22.hiltbase.adapter.PostAdapter
import com.jadhavrupesh22.hiltbase.databinding.ActivityMainBinding
import com.jadhavrupesh22.hiltbase.model.Post
import com.jadhavrupesh22.hiltbase.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter


    lateinit var binding:ActivityMainBinding

    private val TAG = "MainActivity"
    private var loading = false

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUi()
        mainViewModel.getPost()
        mainViewModel.postLiveData.observe(this, Observer {response->
            if (response.isNullOrEmpty()){
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.INVISIBLE
                postAdapter.setData(response as ArrayList<Post>)
            }
        })
    }

    private fun setUi() {
        postAdapter= PostAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }


}