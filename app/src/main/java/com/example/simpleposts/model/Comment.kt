package com.example.simpleposts.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comment(
    val username: String,
    val comment: String
): Parcelable

//@Parcelize
//class Comments: ArrayList<Comment>(), Parcelable