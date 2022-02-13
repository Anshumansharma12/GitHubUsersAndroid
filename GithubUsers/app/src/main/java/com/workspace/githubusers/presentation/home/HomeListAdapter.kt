package com.workspace.githubusers.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.workspace.githubusers.databinding.ItemRowUserBinding
import com.workspace.githubusers.domain.model.User
import com.workspace.githubusers.utils.viewUtils.load

/**
 * Created by Anshuman Sharma on 12/02/22.
 */
class HomeListAdapter :
    PagingDataAdapter<User, HomeListAdapter.UserListViewHolder>(UserComparator()) {

    var userClickListener: UserClickListener? = null

    inner class UserListViewHolder(private val binding: ItemRowUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            userClickListener
            itemView.setOnClickListener {
//                UserClickListener?.onUserClicked(
//                    getItem(absoluteAdapterPosition)
//                )
            }
        }

        fun bindUser(mUser: User) {
            binding.apply {
                ivUser.load(mUser.avatarUrl)
                binding.txtUsername.text = mUser.login
                binding.txtUserId.text = mUser.id.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding =
            ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        getItem(position)?.let { holder.bindUser(it) }
    }

    class UserComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) =
            oldItem == newItem
    }

    interface UserClickListener {
        fun onUserClicked(User: User?)
    }
}