package com.erkumardevender.githubdemo.domain

import javax.inject.Inject

class FetchClosedPRUseCase @Inject constructor(private val gitRepo: GitRepo) {
    suspend fun getClosedPRs()=gitRepo.getPullRequests("closed")
}