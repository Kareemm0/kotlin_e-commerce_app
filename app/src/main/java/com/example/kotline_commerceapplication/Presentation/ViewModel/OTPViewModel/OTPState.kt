package com.example.kotline_commerceapplication.Presentation.ViewModel.OTPViewModel

sealed interface OTPState {
    data object OTPInitState : OTPState
    data object ResendOTPLoadingState : OTPState
    data class ResendOTPSuccessState(val message: String) : OTPState
    data object ResendOTPFailureState : OTPState

}