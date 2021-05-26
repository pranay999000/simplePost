package com.example.simpleposts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Post(
    val avatar: String,
    val username: String,
    val picture: String,
    val comments: ArrayList<Comment>
)

@Parcelize
class Comments: ArrayList<Comment>(), Parcelable
