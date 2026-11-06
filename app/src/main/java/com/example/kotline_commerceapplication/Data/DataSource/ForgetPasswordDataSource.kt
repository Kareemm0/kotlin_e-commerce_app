package com.example.kotline_commerceapplication.Data.DataSource

import com.example.kotline_commerceapplication.Core.Inputs.ResendOTPInput
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ForgetPasswordDataSource {
    @POST("auth/forgot-password")
    fun forgetPassword(
        @Body body: ResendOTPInput
    ): Call<String>
}

