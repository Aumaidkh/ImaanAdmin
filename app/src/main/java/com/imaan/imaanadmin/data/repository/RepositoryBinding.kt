package com.imaan.imaanadmin.data.repository

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBinding {

    @Singleton
    @Binds
    internal abstract fun providesOtpRepository(impl: OtpRepositoryImpl): OtpRepository

    @Singleton
    @Binds
    internal abstract fun providesUserRepository(impl: UserRepositoryImpl): IUserRepository
}