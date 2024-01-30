package com.imaan.imaanadmin.presentation.login

import androidx.lifecycle.ViewModel
import com.imaan.imaanadmin.data.repository.IUserRepository
import com.imaan.imaanadmin.data.repository.OtpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val otpRepository: OtpRepository,
    private val userRepository: IUserRepository
): ViewModel(){


}