package com.imaan.imaanadmin.data.repository

import com.imaan.imaanadmin.core.utils.Result
import com.imaan.imaanadmin.data.datasource.OTPService
import com.imaan.imaanadmin.data.model.OTPModel
import com.imaan.imaanadmin.data.model.UserModel
import javax.inject.Inject

class OtpRepositoryImpl @Inject constructor(
    private val otpService: OTPService,
    private val userRepository: IUserRepository
) : OtpRepository {

    override suspend fun requestOtpOn(phone: String): Result<OTPModel> {
        return otpService.requestOtpOnPhoneNumber(phone)
    }

    override suspend fun verifyOtp(
        otp: String,
        phone: String
    ): Result<UserModel> {
        val otpResult = otpService.verifyOtpSentOn(
            otp,
            phone
        )

        when(otpResult){
            is Result.Success -> {
                userRepository.getUserInfo(
                    userId = otpResult.data
                ).also {
                    return when(it){
                        is Result.Success -> {
                            Result.Success(data = it.data)
                        }

                        is Result.Error -> {
                            Result.Error(error = it.error)
                        }
                    }
                }
            }
            is Result.Error -> {
                return Result.Error(otpResult.error)
            }
        }
    }
}