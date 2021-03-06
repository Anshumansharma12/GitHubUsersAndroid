package com.workspace.githubusers.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.workspace.githubusers.data.local.entity.UserEntity

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userList: List<UserEntity>)

    @Query("SELECT * FROM user_table")
    fun fetchUser(): PagingSource<Int, UserEntity>

    @Query("DELETE FROM user_table")
    suspend fun clearAllUser()

}