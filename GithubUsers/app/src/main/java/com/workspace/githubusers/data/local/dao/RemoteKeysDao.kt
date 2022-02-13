package com.workspace.githubusers.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.workspace.githubusers.data.local.entity.RemoteKeysEntity

/**
 * Created by Anshuman Sharma on 11/02/22.
 */
@Dao
interface RemoteKeysDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeysEntity>)

    @Query("SELECT * FROM remote_keys where rpoId = :id")
    suspend fun getRemoteKeys(id: Int?): RemoteKeysEntity?

    @Query("DELETE FROM remote_keys")
    suspend fun clearAll()
}