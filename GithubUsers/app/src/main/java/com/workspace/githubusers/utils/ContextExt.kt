package com.workspace.githubusers.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by Anshuman Sharma on 11/02/22.
 */
@Suppress("DEPRECATION")
@SuppressLint("MissingPermission")
fun Context.isConnectedNetwork(): Boolean = run {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    activeNetwork?.isConnectedOrConnecting == true
}

inline fun <reified T> String.getEmptyOrDefault(default: () -> T): T {
    return if (isNullOrEmpty() || this == "null") {
        default()
    } else {
        this as T
    }
}