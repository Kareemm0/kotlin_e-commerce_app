package com.example.kotline_commerceapplication.Presentation.ViewModel.ForgetpasswordVeiwModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotline_commerceapplication.Core.Inputs.ResendOTPInput
import com.example.kotline_commerceapplication.Core.Network.RetrofitService
import com.example.kotline_commerceapplication.Data.DataSource.ForgetPasswordDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetPasswordViewModel : ViewModel() {

    private val forgetPasswordApiService: ForgetPasswordDataSource
    private val _forgetPasswordState =
        MutableStateFlow<ForgetPasswordState>(value = ForgetPasswordState.ForgetPasswordInitState)

    var forgetPasswordState = _forgetPasswordState.asStateFlow()

    init {
        val retrofit = RetrofitService.retrofit
        forgetPasswordApiService = retrofit.create(ForgetPasswordDataSource::class.java)

    }

    fun forgetPassword(
        email: String
    ) {
        viewModelScope.launch {
            _forgetPasswordState.value = ForgetPasswordState.ForgetPasswordLoadingState
            forgetPasswordApiService.forgetPassword(
                body = ResendOTPInput(
                    email
                )
            ).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String?>, response: Response<String?>) {
                    if (response.isSuccessful) {
                        var message = response.body().toString()
                        _forgetPasswordState.value =
                            ForgetPasswordState.ForgetPasswordSuccessState(message)
                    } else {
                        _forgetPasswordState.value = ForgetPasswordState.ForgetPasswordFailureState
                    }
                }

                override fun onFailure(call: Call<String?>, t: Throwable) {
                    _forgetPasswordState.value = ForgetPasswordState.ForgetPasswordFailureState
                }
            })

        }
    }


}