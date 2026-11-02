package com.example.kotline_commerceapplication.Presentation.ViewModel.OTPViewModel

sealed interface OTPState {
    data object OTPInitState : OTPState
    data object ResendOTPLoadingState : OTPState
    data class ResendOTPSuccessState(val message: String) : OTPState
    data object ResendOTPFailureState : OTPState


    data object VerifyOTPLoadingState : OTPState

    data class VerifyOTPSuccessState(var message: String) : OTPState

    data object VerifyOTPFailureState : OTPState


    data object VerifyEmailLoadingState : OTPState
    data object VerifyEmailSuccessState : OTPState
    data object VerifyEmailFailureState : OTPState
}