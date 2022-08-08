package com.erkumardevender.githubdemo.data.models

import com.google.gson.annotations.SerializedName

data class GitUser(@SerializedName("login") val userName:String,
                   @SerializedName("avatar_url") val userAvatarUrl:String)
