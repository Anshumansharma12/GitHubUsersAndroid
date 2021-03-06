package com.workspace.githubusers.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.workspace.githubusers.data.local.entity.UserDetailEntity

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
@Dao
interface UserDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserDetailsToDB(userDetails: UserDetailEntity)

    @Query("SELECT * FROM user_details_table WHERE login = :userName")
    suspend fun getUserDetailsByUserName(userName: String): UserDetailEntity?
}