package com.workspace.githubusers.di

import com.workspace.githubusers.domain.usecase.UserUseCase
import com.workspace.githubusers.domain.usecase.UserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * Created by Anshuman Sharma on 10/02/22.
 */

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideUserUseCase(userUseCaseImpl: UserUseCaseImpl) : UserUseCase

}