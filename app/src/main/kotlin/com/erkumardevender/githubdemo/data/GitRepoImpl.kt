package com.erkumardevender.githubdemo.data

import com.erkumardevender.githubdemo.data.models.GitUser
import com.erkumardevender.githubdemo.data.models.PullRequest
import com.erkumardevender.githubdemo.domain.GitRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitRepoImpl @Inject constructor(private val apiService: ApiService): GitRepo {

    override suspend fun getPullRequests(state: String): Flow<List<PullRequest>> {
        return flow {
            val apiCall=apiService.getPullRequests(state)
            if (apiCall.isSuccessful){
                emit(apiCall.body()!!)
            }else{
                emit(emptyList())
            }
        }
    }
}