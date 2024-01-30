package com.imaan.imaanadmin.data.repository

import com.imaan.imaanadmin.core.utils.Result
import com.imaan.imaanadmin.data.model.UserModel

interface IUserRepository {

    suspend fun getUserInfo(userId: String): Result<UserModel>

}