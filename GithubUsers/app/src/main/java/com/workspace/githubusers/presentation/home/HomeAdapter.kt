package com.workspace.githubusers.presentation.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workspace.githubusers.R
import com.workspace.githubusers.databinding.ItemRowUserBinding
import com.workspace.githubusers.domain.model.User
import com.workspace.githubusers.presentation.detail.UserDetailsActivity
import com.workspace.githubusers.utils.viewUtils.load

/**
 * Created by Anshuman Sharma on 10/02/22.
 */
class HomeAdapter(val context: Context) :
    PagingDataAdapter<User, HomeAdapter.ViewHolder>(UserComparator()) {

    private var items = MutableLiveData<PagingData<User>>()
    private lateinit var homeActivity: HomeActivity

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemRowUserBinding = ItemRowUserBinding.bind(itemView)

        fun bind(data: User) {
            binding.apply {
                ivUser.load(data.avatarUrl)
                binding.txtUsername.text = data.login
                binding.txtUserId.text = data.id.toString()
            }
            with(itemView) {
                setOnClickListener {
                    context.startActivity(
                        Intent(context, UserDetailsActivity::class.java).apply {
                            putExtra(UserDetailsActivity.USERNAME_KEY, data.login)
                        }
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_row_user, viewGroup, false)
        )
    }

    fun setActivity(activity: HomeActivity) {
        this.homeActivity = activity
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    class UserComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) =
            oldItem == newItem
    }
}