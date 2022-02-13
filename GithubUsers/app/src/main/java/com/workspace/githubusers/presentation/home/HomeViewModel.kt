package com.workspace.githubusers.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.workspace.githubusers.domain.model.User
import com.workspace.githubusers.domain.usecase.UserUseCase
import com.workspace.githubusers.utils.state.LoaderState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Anshuman Sharma on 10/02/22.
 */
@ExperimentalCoroutinesApi
class HomeViewModel @ViewModelInject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _state = MutableLiveData<LoaderState>()
    val state: LiveData<LoaderState>
        get() = _state

    private val _networkError = MutableLiveData<Boolean>()
    val networkError: LiveData<Boolean>
        get() = _networkError

    private val _resultUserApi = MutableLiveData<PagingData<User>>()
    val resultUserApi: LiveData<PagingData<User>>
        get() = _resultUserApi

    fun getUserFromApi() {
        _state.value = LoaderState.ShowLoading
        viewModelScope.launch {
            userUseCase.getUser().collect {
                _resultUserApi.postValue(it)
                _state.value = LoaderState.HideLoading
            }
        }
    }
}