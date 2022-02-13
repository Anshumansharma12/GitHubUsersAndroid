package com.workspace.githubusers.utils

import androidx.paging.PagingData
import androidx.paging.map
import com.workspace.githubusers.data.local.entity.UserDetailEntity
import com.workspace.githubusers.data.local.entity.UserEntity
import com.workspace.githubusers.domain.model.User
import com.workspace.githubusers.domain.model.UserDetail
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
object DataMapper {

    fun mapUserResponseToDomain(data: PagingData<UserEntity>): PagingData<User> =
        data.map {
            User(
                id = it.id,
                avatarUrl = it.avatarUrl,
                login = it.login,
            )
        }


    fun mapUserResponseToEntities(data: ArrayList<User>): List<UserEntity> =
        data.map {
            UserEntity(
                id = it.id,
                avatarUrl = it.avatarUrl,
                login = it.login,
            )
        }


    fun mapUserDetailResponseToDomain(data: UserDetailEntity): UserDetail =
        UserDetail(
            id = data.id,
            name = data.name,
            avatarUrl = data.avatarUrl,
            emailId = data.emailId,
            company = data.company,
            followers = data.followers,
            following = data.following,
            createdAt = data.createdAt,
            login = data.login
        )

    fun mapUserEntitiesToDomain(data: PagingData<User>): PagingData<User> =
        data.map {
            User(
                id = it.id,
                avatarUrl = it.avatarUrl,
                login = it.login,
            )
        }

    fun mapUserDetailResponseToEntities(data: UserDetail): UserDetailEntity =
        UserDetailEntity(
            id = data.id,
            name = data.name,
            avatarUrl = data.avatarUrl,
            emailId = data.emailId,
            company = data.company,
            followers = data.followers,
            following = data.following,
            createdAt = data.createdAt,
            login = data.login
        )

    fun getFormatDateAndTime(mDateTime: String): String {
        var mDateTimeOut = mDateTime
        try {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val formatter = SimpleDateFormat("'Date : 'dd-MM-yyyy\n'Time : 'KK:mm a")
            mDateTimeOut = formatter.format(parser.parse(mDateTimeOut))
        } catch (e: ParseException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return mDateTimeOut
    }


}