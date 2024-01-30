package com.imaan.imaanadmin.data.repository

import com.imaan.imaanadmin.core.utils.Result
import com.imaan.imaanadmin.data.model.OTPModel
import com.imaan.imaanadmin.data.model.UserModel

interface OtpRepository {

    suspend fun requestOtpOn(phone: String): Result<OTPModel>

    suspend fun verifyOtp(otp: String,phone: String): Result<UserModel>
}