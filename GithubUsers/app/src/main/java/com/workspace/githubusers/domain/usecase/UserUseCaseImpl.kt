package com.workspace.githubusers.domain.usecase

import androidx.paging.PagingData
import com.workspace.githubusers.domain.model.User
import com.workspace.githubusers.domain.model.UserDetail
import com.workspace.githubusers.domain.repository.UserRepository
import com.workspace.githubusers.utils.state.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
class UserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserUseCase {
    override suspend fun getUser(): Flow<PagingData<User>> {
        return userRepository.getUser()
    }

    override suspend fun getUserDetail(username: String): Flow<UserDetail> {
        return userRepository.getUserDetail(username = username)
    }
}