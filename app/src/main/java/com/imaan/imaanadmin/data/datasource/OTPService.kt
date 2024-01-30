package com.imaan.imaanadmin.data.datasource

import com.imaan.imaanadmin.core.utils.Result
import com.imaan.imaanadmin.data.model.OTPModel
import javax.inject.Inject

class OTPService @Inject constructor() {

    suspend fun requestOtpOnPhoneNumber(phone: String): Result<OTPModel>{
        return Result.Success(data = OTPModel("1234"))
    }

    suspend fun verifyOtpSentOn(otp: String,phone: String): Result<String>{
        return Result.Success(data = "someUserId")
    }
}