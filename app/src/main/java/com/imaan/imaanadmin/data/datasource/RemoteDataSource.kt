package com.imaan.imaanadmin.data.datasource

import com.imaan.imaanadmin.core.utils.Result
import com.imaan.imaanadmin.data.model.UserModel
import com.imaan.imaanadmin.data.model.fakeUser
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {
    suspend fun fetchUserDetailsById(userId: String): Result<UserModel>{
        return Result.Success(data = fakeUser)
    }
}