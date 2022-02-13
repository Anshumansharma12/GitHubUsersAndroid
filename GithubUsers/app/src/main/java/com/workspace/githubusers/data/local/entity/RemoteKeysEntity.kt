package com.workspace.githubusers.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Anshuman Sharma on 11/02/22.
 */
@Entity(tableName = "remote_keys")
data class RemoteKeysEntity(
    @PrimaryKey
    val rpoId: Int?,
    val prevKey: Int?,
    val nextKey: Int?
)