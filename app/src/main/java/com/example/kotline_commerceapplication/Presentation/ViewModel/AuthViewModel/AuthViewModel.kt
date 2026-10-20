package com.example.kotline_commerceapplication.Presentation.ViewModel.AuthViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kotline_commerceapplication.Core.Inputs.RegisterInput
import com.example.kotline_commerceapplication.Core.Network.RetrofitService
import com.example.kotline_commerceapplication.Data.DataSource.AuthApiService
import com.example.kotline_commerceapplication.Domain.Models.RegisterModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.time.Duration.Companion.milliseconds


class AuthViewModel : ViewModel() {
    private val authApiService: AuthApiService

    init {
        val retrofit = RetrofitService.retrofit
        authApiService = retrofit.create(AuthApiService::class.java)

    }

  private  val _loginState = MutableStateFlow<AuthState>(AuthState.AuthInitState)

    var loginState = _loginState.asStateFlow()
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


    fun login(
        email: String ,
        password: String
    ){
        viewModelScope.launch {
            _loginState.value = AuthState.AuthLoadingState
            delay(2000.milliseconds)
            if(email.isNotEmpty() && password.isNotEmpty()) {
                _loginState.value = AuthState.AuthSuccessState
            }else{
                _loginState.value = AuthState.AuthFailureState
            }
        }
    }

}