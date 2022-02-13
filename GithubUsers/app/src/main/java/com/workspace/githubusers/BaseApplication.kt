package com.workspace.githubusers

import android.app.Application
import com.workspace.githubusers.utils.const
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        const.init(this)
    }
}