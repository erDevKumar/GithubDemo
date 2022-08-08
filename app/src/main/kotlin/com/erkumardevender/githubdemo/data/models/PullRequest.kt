package com.erkumardevender.githubdemo.data.models

import com.google.gson.annotations.SerializedName

data class PullRequest(val title:String,
                       @SerializedName("created_at") val prCreatedAt:String,
                       @SerializedName("closed_at") val prClosedAt:String,
                       @SerializedName("user") val user:GitUser)
