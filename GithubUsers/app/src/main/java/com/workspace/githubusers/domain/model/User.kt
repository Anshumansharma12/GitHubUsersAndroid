package com.workspace.githubusers.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
data class User(
    @SerializedName("id") val id: Int?,

    @SerializedName("avatar_url") val avatarUrl: String?,

    @SerializedName("login") val login: String?,
)
