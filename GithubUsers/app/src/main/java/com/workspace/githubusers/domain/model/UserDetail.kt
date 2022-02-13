package com.workspace.githubusers.domain.model

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
data class UserDetail(
    @NonNull
    @SerializedName("id") val id: Int?,

    @SerializedName("name") val name: String?,

    @SerializedName("avatar_url") val avatarUrl: String?,

    @SerializedName("email") val emailId: String?,

    @SerializedName("company") val company: String?,

    @SerializedName("followers") val followers: Int?,

    @SerializedName("following") val following: Int?,

    @SerializedName("created_at") val createdAt: String?,

    @SerializedName("login") val login: String?,
)
