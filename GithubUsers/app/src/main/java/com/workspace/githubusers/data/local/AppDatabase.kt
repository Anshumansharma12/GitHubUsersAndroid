package com.workspace.githubusers.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.workspace.githubusers.data.local.dao.RemoteKeysDao
import com.workspace.githubusers.data.local.dao.UserDao
import com.workspace.githubusers.data.local.dao.UserDetailsDao
import com.workspace.githubusers.data.local.entity.RemoteKeysEntity
import com.workspace.githubusers.data.local.entity.UserDetailEntity
import com.workspace.githubusers.data.local.entity.UserEntity

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
@Database(
    entities = [UserEntity::class, UserDetailEntity::class, RemoteKeysEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val userDetailDao: UserDetailsDao
    abstract val remoteKeysDao: RemoteKeysDao
}