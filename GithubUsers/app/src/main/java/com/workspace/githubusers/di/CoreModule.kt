package com.workspace.githubusers.di

import android.app.Application
import androidx.room.Room
import com.workspace.githubusers.BuildConfig
import com.workspace.githubusers.data.local.AppDatabase
import com.workspace.githubusers.data.local.dao.UserDao
import com.workspace.githubusers.data.local.dao.UserDetailsDao
import com.workspace.githubusers.data.remote.Network
import com.workspace.githubusers.data.remote.NetworkService
import com.workspace.githubusers.utils.const.databaseName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

/**
 * Created by Anshuman Sharma on 09/02/22.
 */
@Module
@InstallIn(ApplicationComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService {
        return Network.retrofitClient().create(NetworkService::class.java)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase {
        val passPhare: ByteArray = SQLiteDatabase.getBytes(BuildConfig.PASSPHRASE.toCharArray())
        val factory = SupportFactory(passPhare)

        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            databaseName
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao
    }

    @Singleton
    @Provides
    fun provideUserDetailsDao(appDatabase: AppDatabase): UserDetailsDao {
        return appDatabase.userDetailDao
    }
}