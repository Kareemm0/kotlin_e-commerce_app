package com.example.kotline_commerceapplication.Data.DataSource


import com.example.kotline_commerceapplication.Core.Inputs.ResendOTPInput
import com.example.kotline_commerceapplication.Core.Inputs.VerifyOTPInput
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface OTPApiService {
    @POST("auth/resend-otp")
    fun resendOtp(
        @Body body: ResendOTPInput
    ): Call<String>


    @POST("auth/validate-otp")
    fun verifyOTP(
        @Body body: VerifyOTPInput
    ): Call<String>

    @POST("auth/verify-email")
    fun verifyEmail(
        @Body body: VerifyOTPInput
    ): Call<String>
}