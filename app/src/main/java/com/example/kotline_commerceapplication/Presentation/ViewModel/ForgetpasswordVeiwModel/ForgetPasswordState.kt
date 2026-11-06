package com.example.kotline_commerceapplication.Presentation.ViewModel.ForgetpasswordVeiwModel

sealed interface ForgetPasswordState {

    data object ForgetPasswordInitState : ForgetPasswordState
    data object ForgetPasswordLoadingState : ForgetPasswordState
    data class ForgetPasswordSuccessState(val message: String) : ForgetPasswordState
    data object ForgetPasswordFailureState : ForgetPasswordState
}