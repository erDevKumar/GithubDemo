package com.erkumardevender.githubdemo.domain

import kotlinx.coroutines.flow.Flow


interface GitRepo {
    suspend fun getPullRequests(state:String):Flow<Any?>
}