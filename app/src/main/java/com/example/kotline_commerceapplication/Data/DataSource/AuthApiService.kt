package com.example.kotline_commerceapplication.Data.DataSource

import com.example.kotline_commerceapplication.Core.Inputs.LoginInput
import com.example.kotline_commerceapplication.Core.Inputs.RegisterInput
import com.example.kotline_commerceapplication.Domain.Models.LoginModel
import com.example.kotline_commerceapplication.Domain.Models.RegisterModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/register")
    fun register(
        @Body registerInput: RegisterInput

    ): Call<RegisterModel>


    @POST("auth/login")
    fun login(
        @Body body: LoginInput
    ): Call<LoginModel>
}