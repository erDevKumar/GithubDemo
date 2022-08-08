package com.erkumardevender.githubdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GitDemoApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }

}