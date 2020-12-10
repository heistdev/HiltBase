package com.jadhavrupesh22.hiltbase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jadhavrupesh22.hiltbase.R
import com.jadhavrupesh22.hiltbase.databinding.SinglePostBinding
import com.jadhavrupesh22.hiltbase.model.Post

class PostAdapter(private val context: Context, private var postList: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = DataBindingUtil.inflate<SinglePostBinding>(
            LayoutInflater.from(parent.context),
            R.layout.single_post, parent, false
        )
        return PostViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        val post=postList[position]
//        holder.body.text=post.body

        val currentNote: Post = postList[position]!!
        holder.binding.post = currentNote
        holder.binding.executePendingBindings()

    }

    override fun getItemCount(): Int = postList.size

    fun getPostAt(position: Int): Post {
        return postList[position]!!
    }

    inner class PostViewHolder(val binding: SinglePostBinding) : RecyclerView.ViewHolder(binding.root) {
//        val body: TextView = itemView.findViewById(R.id.body)
//        init {
//            itemView.setOnClickListener {
//                val position = adapterPosition
//                if (position != RecyclerView.NO_POSITION) {
//                    listener?.onItemClick(getPostAt(position))
//                }
//            }
//        }
    }

    fun setData(postList: ArrayList<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

}