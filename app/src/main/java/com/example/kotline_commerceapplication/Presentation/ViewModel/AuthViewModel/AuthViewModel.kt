package com.example.kotline_commerceapplication.Presentation.ViewModel.AuthViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotline_commerceapplication.Core.Inputs.LoginInput
import com.example.kotline_commerceapplication.Core.Inputs.RegisterInput
import com.example.kotline_commerceapplication.Core.Network.RetrofitService
import com.example.kotline_commerceapplication.Data.DataSource.AuthApiService
import com.example.kotline_commerceapplication.Domain.Models.LoginModel
import com.example.kotline_commerceapplication.Domain.Models.RegisterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AuthViewModel : ViewModel() {
    private val authApiService: AuthApiService

    init {
        val retrofit = RetrofitService.retrofit
        authApiService = retrofit.create(AuthApiService::class.java)

    }


    private val _loginState = MutableStateFlow<AuthState>(AuthState.AuthInitState)
    private val _registerState = MutableStateFlow<AuthState>(AuthState.AuthInitState)

    var loginState = _loginState.asStateFlow()
    var registerState = _registerState.asStateFlow()
    fun register(
        registerInput: RegisterInput
    ) {
        viewModelScope.launch {
            _registerState.value = AuthState.AuthLoadingState
            if (registerInput.email.isNotEmpty() && registerInput.password.isNotEmpty()) {
                authApiService.register(registerInput).enqueue(object : Callback<RegisterModel> {
                    override fun onResponse(
                        call: Call<RegisterModel?>,
                        response: Response<RegisterModel?>
                    ) {
                        if (response.isSuccessful) {
                            val responseData = response.body()
                            println("============================================================== $responseData")
                            _registerState.value = AuthState.AuthSuccessState

                        } else {
                            _registerState.value = AuthState.AuthFailureState
                        }
                    }

                    override fun onFailure(
                        p0: Call<RegisterModel?>,
                        p1: Throwable
                    ) {

                        _registerState.value = AuthState.AuthFailureState
                    }
                })


            } else {
                println("Error In View Model ")

            }
        }
    }


    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _loginState.value = AuthState.AuthLoadingState
            authApiService.login(
                body = LoginInput(
                    email, password
                )
            ).enqueue(
                object : Callback<LoginModel> {
                    override fun onResponse(
                        call: Call<LoginModel?>,
                        response: Response<LoginModel?>
                    ) {
                        if (response.isSuccessful) {
                            val responseData = response.body()
                            println("============================================================== $responseData")
                            _loginState.value = AuthState.AuthSuccessState
                        }
                    }

                    override fun onFailure(
                        call: Call<LoginModel?>,
                        t: Throwable
                    ) {
                        println("===========$t")
                        _loginState.value = AuthState.AuthFailureState
                    }
                })


        }
    }

}