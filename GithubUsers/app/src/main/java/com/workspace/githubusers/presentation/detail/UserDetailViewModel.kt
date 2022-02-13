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
     * error
     */
    private val _error = MutableLiveData<String>()

    /**
     * Network error
     */
    private val _networkError = MutableLiveData<Boolean>()

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
//                when (it) {
//                    is ResultState.Success -> _resultUserDetail.postValue(it.data)
//                    is ResultState.Error -> _error.postValue(it.error)
//                    is ResultState.NetworkError -> _networkError.postValue(true)
//                }
            }

        }
    }

    /**
     * Local
     */
//    fun addUserToDB(userFavoriteEntity: UserFavorite) {
//        viewModelScope.launch {
//            try {
//                userUseCase.addUserToFavDB(userFavoriteEntity)
//                _resultInsertUserToDb.postValue(true)
//            }catch (e: Exception) {
//                _error.postValue(e.localizedMessage)
//            }
//        }
//    }
//
//    fun getFavUserByUsername(username: String) = userUseCase.getFavUserByUsername(username).asLiveData()
}