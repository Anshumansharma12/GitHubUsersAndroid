package com.workspace.githubusers.utils

import android.content.Context

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
object const {
    const val databaseName = "git_user_database"
    lateinit var mContext: Context

    fun init(context: Context) {
        this.mContext = context
    }
}