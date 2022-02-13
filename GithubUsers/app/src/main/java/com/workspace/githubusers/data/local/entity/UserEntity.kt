package com.workspace.githubusers.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey
    val id: Int?,

    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String?,

    @ColumnInfo(name = "login")
    val login: String?
)
