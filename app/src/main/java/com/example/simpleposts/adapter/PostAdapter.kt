package com.example.simpleposts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleposts.databinding.PostItemsBinding
import com.example.simpleposts.fragment.PostFragment
import com.example.simpleposts.fragment.PostFragmentDirections
import com.example.simpleposts.model.Comments
import com.example.simpleposts.model.Post
import com.squareup.picasso.Picasso

class PostAdapter(var list: List<Post>, var context: Context?): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: PostItemsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                Picasso.get().load(this.avatar).into(binding.avatar)
                binding.userName.text = this.username
                Picasso.get().load(this.picture).into(binding.postImage)
            }
        }

        holder.itemView.setOnClickListener { view: View ->
            view.findNavController().navigate(PostFragmentDirections.actionPostFragmentToPostDetailsFragment(
                list[holder.adapterPosition].username,
                list[holder.adapterPosition].avatar,
                list[holder.adapterPosition].comments as Comments,
                list[holder.adapterPosition].picture
            ))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}