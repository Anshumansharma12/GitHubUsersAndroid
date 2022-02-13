package com.workspace.githubusers.domain.repository

import androidx.paging.PagingData
import com.workspace.githubusers.domain.model.User
import com.workspace.githubusers.domain.model.UserDetail
import kotlinx.coroutines.flow.Flow

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
interface UserRepository {

    /**
     * Remote
     */
    suspend fun getUser(): Flow<PagingData<User>>
    suspend fun getUserDetail(username: String): Flow<UserDetail>

}