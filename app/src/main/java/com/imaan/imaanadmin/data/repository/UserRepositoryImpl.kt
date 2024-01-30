package com.imaan.imaanadmin.data.repository

import com.imaan.imaanadmin.core.utils.Result
import com.imaan.imaanadmin.data.datasource.RemoteDataSource
import com.imaan.imaanadmin.data.model.UserModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): IUserRepository {
    override suspend fun getUserInfo(userId: String): Result<UserModel> {
        return remoteDataSource.fetchUserDetailsById(userId)
    }
}