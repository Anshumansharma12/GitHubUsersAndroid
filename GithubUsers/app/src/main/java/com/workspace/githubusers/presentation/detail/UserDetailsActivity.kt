package com.workspace.githubusers.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.workspace.githubusers.R
import com.workspace.githubusers.databinding.ActivityUserDetailBinding
import com.workspace.githubusers.domain.model.UserDetail
import com.workspace.githubusers.utils.state.LoaderState
import com.workspace.githubusers.utils.viewUtils.load
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Anshuman Sharma on 10/02/22.
 */
@AndroidEntryPoint
class UserDetailsActivity : AppCompatActivity() {

    private val binding: ActivityUserDetailBinding by lazy {
        ActivityUserDetailBinding.inflate(layoutInflater)
    }

    private val userDetailViewModel: UserDetailViewModel by viewModels()

    private var userDetail: UserDetail? = null

    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handleIntent()
        initObserver()
        fetchData()
        initToolbar()

    }

    fun getUsername(): String? {
        return username
    }

    private fun initToolbar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            elevation = 0f
            title = "$username\'s Profile"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun fetchData() {
        username?.let {
            userDetailViewModel.getUserDetailFromApi(it)
        }
    }

    private fun handleIntent() {
        username = intent.getStringExtra(USERNAME_KEY) as String
    }

    private fun initObserver() {
        with(userDetailViewModel) {
            state.observe(this@UserDetailsActivity) {
                handleStateLoading(it)
            }
            resultUserDetail.observe(this@UserDetailsActivity) {
                handleResultUserDetail(it)
            }
//            username?.let {
//                getFavUserByUsername(it).observe(this@UserDetailsActivity, {
//                    handleUserDetailFromDb(it)
//                })
//            }
//            resultInsertUserDb.observe(this@UserDetailsActivity, { it ->
//                if (it) {
//                    username?.let {
//                        userDetailViewModel.getFavUserByUsername(it)
//                    }
//                    toast(getString(R.string.user_success))
//                }
//            })
//            resultDeleteFromDb.observe(this@UserDetailActivity, { it ->
//                if (it) {
//                    username?.let {
//                        userDetailViewModel.getFavUserByUsername(it)
//                    }
//                    toast(getString(R.string.user_deleted))
//                }
//            })
        }

    }

    private fun handleStateLoading(loading: LoaderState) {
        if (loading is LoaderState.ShowLoading) {
//            binding.favButton.setGone()
        } else {
//            binding.favButton.setVisible()
        }
    }


    private fun handleResultUserDetail(data: UserDetail) {
        userDetail = data
        binding.apply {
            txtUsername.text = data.name
            txtEmail.text = data.emailId ?: getString(R.string.no_email)
            txtFollower.text = data.followers.toString()
            txtFollowing.text = data.following.toString()
            txtCompany.text = data.company ?: getString(R.string.no_company)
            txtCreatedOn.text = data.createdAt.toString()
            ivUser.load(data.avatarUrl)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFinishAfterTransition()
    }

    companion object {
        const val USERNAME_KEY = "username_key"
    }
}