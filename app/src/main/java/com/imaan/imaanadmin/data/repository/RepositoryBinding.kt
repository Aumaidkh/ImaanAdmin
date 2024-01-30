package com.imaan.imaanadmin.data.repository

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBinding {

    @Provides
    @Binds
    internal abstract fun providesOtpRepository(impl: OtpRepositoryImpl): OtpRepository

    @Provides
    @Binds
    internal abstract fun providesUserRepository(impl: UserRepositoryImpl): UserRepositoryImpl
}