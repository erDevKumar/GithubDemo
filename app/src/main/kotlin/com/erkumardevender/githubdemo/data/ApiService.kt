package com.erkumardevender.githubdemo.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repos/erDevKumar/GithubDemo/pulls")
    suspend fun getPullRequests(@Query("state")state:String):Response<Any?>
}