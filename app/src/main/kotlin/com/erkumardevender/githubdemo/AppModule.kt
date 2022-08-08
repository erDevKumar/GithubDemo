package com.erkumardevender.githubdemo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.erkumardevender.githubdemo.data.ApiService
import com.erkumardevender.githubdemo.data.GitRepoImpl
import com.erkumardevender.githubdemo.domain.GitRepo
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideGitRepo(apiService: ApiService): GitRepo {
        return GitRepoImpl(apiService)
    }
}