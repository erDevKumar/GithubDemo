package com.erkumardevender.githubdemo.data

import com.erkumardevender.githubdemo.data.models.GitUser
import com.erkumardevender.githubdemo.data.models.PullRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repos/erDevKumar/GithubDemo/pulls")
    suspend fun getPullRequests(@Query("state")state:String):Response<List<PullRequest>>
}