package com.example.kotline_commerceapplication.Presentation.ViewModel.OTPViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotline_commerceapplication.Core.Inputs.ResendOTPInput
import com.example.kotline_commerceapplication.Core.Network.RetrofitService
import com.example.kotline_commerceapplication.Data.DataSource.OTPApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OTPViewModel : ViewModel() {

    private val otpService: OTPApiService

    init {
        val retrofit = RetrofitService.retrofit
        otpService = retrofit.create(OTPApiService::class.java)
    }

    private val _resendOTPState = MutableStateFlow<OTPState>(OTPState.OTPInitState)
    var resendOTPState = _resendOTPState.asStateFlow()
    
    fun resendOTP(
        email: String
    ) {
        viewModelScope.launch {
            _resendOTPState.value = OTPState.ResendOTPLoadingState

            otpService.resendOtp(
                body = ResendOTPInput(
                    email = email
                )
            ).enqueue(object : Callback<String> {
                override fun onResponse(
                    call: Call<String?>,
                    response: Response<String?>
                ) {
                    if (response.isSuccessful) {
                        val message: String = response.body().toString()
                        _resendOTPState.value =
                            OTPState.ResendOTPSuccessState(message)
                        println("===============================$message")
                    } else {
                        _resendOTPState.value = OTPState.ResendOTPFailureState
                    }
                }

                override fun onFailure(
                    call: Call<String?>,
                    error: Throwable
                ) {
                    _resendOTPState.value = OTPState.ResendOTPFailureState
                    println("========= Error is $error")
                }
            })

        }
    }


}