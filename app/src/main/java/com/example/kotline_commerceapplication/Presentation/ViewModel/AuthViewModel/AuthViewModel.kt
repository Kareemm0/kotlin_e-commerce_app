package com.example.kotline_commerceapplication.Presentation.ViewModel.AuthViewModel

import androidx.lifecycle.ViewModel
import com.example.kotline_commerceapplication.Core.Inputs.RegisterInput
import com.example.kotline_commerceapplication.Core.Network.RetrofitService
import com.example.kotline_commerceapplication.Data.DataSource.AuthApiService
import com.example.kotline_commerceapplication.Domain.Models.RegisterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthViewModel : ViewModel() {
    private val authApiService: AuthApiService

    init {
        val retrofit = RetrofitService.retrofit
        authApiService = retrofit.create(AuthApiService::class.java)
    }

    fun register(
        registerInput: RegisterInput
    ) {
        authApiService.register(registerInput).enqueue(object : Callback<RegisterModel> {
            override fun onResponse(
                p0: Call<RegisterModel?>,
                p1: Response<RegisterModel?>
            ) {

            }

            override fun onFailure(
                p0: Call<RegisterModel?>,
                p1: Throwable
            ) {
                TODO("Not yet implemented")
            }
        })
    }
}