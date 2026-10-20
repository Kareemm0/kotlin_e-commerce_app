package com.example.kotline_commerceapplication.Presentation.ViewModel.AuthViewModel

sealed interface AuthState{
    data object  AuthInitState: AuthState
    data object  AuthLoadingState: AuthState
    data object AuthSuccessState: AuthState
    data object AuthFailureState: AuthState
}