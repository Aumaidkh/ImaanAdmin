package com.imaan.imaanadmin.data.datasource

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesRemoteDatasource() = RemoteDataSource()

    @Provides
    @Singleton
    fun providesOtpService() = OTPService()
}