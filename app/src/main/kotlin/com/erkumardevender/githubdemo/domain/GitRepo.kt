package com.erkumardevender.githubdemo.domain

import com.erkumardevender.githubdemo.data.models.GitUser
import com.erkumardevender.githubdemo.data.models.PullRequest
import kotlinx.coroutines.flow.Flow


interface GitRepo {
    suspend fun getPullRequests(state:String):Flow<List<PullRequest>>
}