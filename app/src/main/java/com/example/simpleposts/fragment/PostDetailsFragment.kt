package com.example.simpleposts.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleposts.R
import com.example.simpleposts.adapter.CommentsAdapter
import com.example.simpleposts.databinding.FragmentPostDetailsBinding
import com.example.simpleposts.model.Comment
import com.squareup.picasso.Picasso

class PostDetailsFragment : Fragment() {
    private lateinit var commentAdapter: CommentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPostDetailsBinding = FragmentPostDetailsBinding.inflate(inflater, container, false)

        val details = PostDetailsFragmentArgs.fromBundle(requireArguments())
        val comments = details.comments

        binding.userName.text = details.username
        Picasso.get().load(details.avatar).into(binding.avatar)
        Picasso.get().load(details.picture).into(binding.postImage)

        commentAdapter = CommentsAdapter(comments)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.commentsRecycler.layoutManager = linearLayoutManager
        binding.commentsRecycler.setHasFixedSize(true)
        binding.commentsRecycler.adapter = commentAdapter

        return binding.root
    }
}