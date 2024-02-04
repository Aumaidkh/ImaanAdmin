package com.imaan.imaanadmin.data.repository.order

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class OrderModuleBinding {
    @Singleton
    @Binds
    abstract fun bindsOrderRepository(impl: OrderRepositoryImpl):IOrderRepository
}