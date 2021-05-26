package com.example.simpleposts.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleposts.adapter.PostAdapter
import com.example.simpleposts.databinding.FragmentPostBinding
import com.example.simpleposts.model.Comment
import com.example.simpleposts.model.Comments
import com.example.simpleposts.model.Post

class PostFragment : Fragment() {
    private lateinit var postList: List<Post>
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPostBinding = FragmentPostBinding.inflate(inflater, container, false);

        postList = fillPosts()
        postAdapter = PostAdapter(postList, context)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recycler.layoutManager = linearLayoutManager
        binding.recycler.setHasFixedSize(true)
        binding.recycler.adapter = postAdapter
        postAdapter.notifyDataSetChanged()


        return binding.root
    }

    private fun fillPosts(): List<Post> {

        return listOf(
                Post(
                        "https://upload.wikimedia.org/wikipedia/en/d/d7/Harry_Potter_character_poster.jpg",
                        "Harry Potter",
                        "https://upload.wikimedia.org/wikipedia/en/d/df/Harry_Potter_and_the_Deathly_Hallows_%E2%80%93_Part_2.jpg",
                         loadArrayList("harry")
                ),
                Post(
                        "https://upload.wikimedia.org/wikipedia/en/d/d3/Hermione_Granger_poster.jpg",
                        "Hermione Granger",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/HPatDH_-_Panache_-_Emma_and_Dobby.jpg/330px-HPatDH_-_Panache_-_Emma_and_Dobby.jpg",
                         loadArrayList("harmione")
                ),
                Post(
                        "https://upload.wikimedia.org/wikipedia/en/5/5e/Ron_Weasley_poster.jpg",
                        "Ron Wesley",
                        "https://upload.wikimedia.org/wikipedia/en/1/14/Weasleys.jpg",
                         loadArrayList("ron")
                )
        )
    }

    private fun loadArrayList(s: String): java.util.ArrayList<Comment> {

        val arrayList = Comments()

        when (s) {
            "harry" -> {
                arrayList.add(Comment("Hermione Granger","I like Ron."))
                arrayList.add(Comment("Ron Wesley", "Harry is my best friend."))
                arrayList.add(Comment("Cho", "I like Harry."))
            }
            "harmione" -> {
                arrayList.add(Comment("Harry Potter", "I killed Voldmort"))
                arrayList.add(Comment("Ron Wesley", "I look like a football"))
            }
            "ron" -> {
                arrayList.add(Comment("Harry", "You are my best friend."))
                arrayList.add(Comment("Hermione", "You look like Ed Sheeran"))
            }
        }

        return arrayList
    }
}