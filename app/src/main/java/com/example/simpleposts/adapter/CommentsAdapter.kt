package com.example.simpleposts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleposts.databinding.CommentItemBinding
import com.example.simpleposts.model.Comments

class CommentsAdapter(var list: Comments): RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: CommentItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.commentUser.text = this.username
                binding.commentBody.text = this.comment
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}