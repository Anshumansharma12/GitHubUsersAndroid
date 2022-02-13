package com.workspace.githubusers.presentation.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workspace.githubusers.domain.model.UserDetail
import com.workspace.githubusers.domain.usecase.UserUseCase
import com.workspace.githubusers.utils.state.LoaderState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Anshuman Sharma on 10/02/22.
 */
class UserDetailViewModel @ViewModelInject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    /**
     * Loader state
     */
    private val _state = MutableLiveData<LoaderState>()
    val state: LiveData<LoaderState>
        get() = _state

    /**
     * User detail remote
     */
    private val _resultUserDetail = MutableLiveData<UserDetail>()
    val resultUserDetail: LiveData<UserDetail>
        get() = _resultUserDetail

    /**
     * Insert to DB
     */
    private val _resultInsertUserToDb = MutableLiveData<Boolean>()
    val resultInsertUserDb: LiveData<Boolean>
        get() = _resultInsertUserToDb

    /**
     * Delete from db
     */
    private val _resultDeleteFromDb = MutableLiveData<Boolean>()
    val resultDeleteFromDb: LiveData<Boolean>
        get() = _resultDeleteFromDb

    /**
     * Remote
     */
    fun getUserDetailFromApi(username: String) {
        _state.value = LoaderState.ShowLoading
        viewModelScope.launch {
            userUseCase.getUserDetail(username).collect {
                _state.value = LoaderState.HideLoading
                _resultUserDetail.postValue(it)
            }
        }
    }
}