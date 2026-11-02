package com.example.kotline_commerceapplication.Presentation.ViewModel.OTPViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotline_commerceapplication.Core.Inputs.ResendOTPInput
import com.example.kotline_commerceapplication.Core.Inputs.VerifyOTPInput
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
    private val _verifyOTPState = MutableStateFlow<OTPState>(OTPState.OTPInitState)
    private val _verifyEmailState = MutableStateFlow<OTPState>(OTPState.OTPInitState)
    var resendOTPState = _resendOTPState.asStateFlow()
    var verifyOTPState = _verifyOTPState.asStateFlow()

    var verifyEmailState = _verifyEmailState.asStateFlow()

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


    fun verifyOTP(
        body: VerifyOTPInput
    ) {
        _verifyOTPState.value = OTPState.VerifyOTPLoadingState
        viewModelScope.launch {

            otpService.verifyOTP(
                body = body
            ).enqueue(
                object : Callback<String> {
                    override fun onResponse(
                        call: Call<String?>,
                        response: Response<String?>
                    ) {
                        if (response.isSuccessful) {
                            val message: String = response.body().toString()
                            _verifyOTPState.value =
                                OTPState.VerifyOTPSuccessState(message)
                            println("===============================$message")
                        } else {
                            _verifyOTPState.value = OTPState.VerifyOTPFailureState
                        }
                    }

                    override fun onFailure(
                        call: Call<String?>,
                        t: Throwable
                    ) {
                        println("====================$t")
                    }
                })
        }
    }


    fun verifyEmail(
        body: VerifyOTPInput
    ) {
        viewModelScope.launch {
            _verifyEmailState.value = OTPState.VerifyEmailLoadingState
            otpService.verifyEmail(
                body
            ).enqueue(
                object : Callback<String> {
                    override fun onResponse(call: Call<String?>, response: Response<String?>) {
                        if (response.isSuccessful) {
                            _verifyEmailState.value = OTPState.VerifyEmailSuccessState
                        } else {
                            _verifyEmailState.value = OTPState.VerifyEmailFailureState
                        }
                    }

                    override fun onFailure(call: Call<String?>, t: Throwable) {
                        _verifyEmailState.value = OTPState.VerifyEmailFailureState

                    }
                }
            )
        }
    }
}