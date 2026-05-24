package com.example.kotline_commerceapplication.App

sealed class Routes(val route: String) {
    object Splash : Routes("splash_screen")
    object Login : Routes("login_screen")
    object SignUp : Routes("SignUp_screen")
    object ForgetPassword : Routes("forgetPassword_screen")
    object ResetPassword : Routes("resetPassword_screen")
    object Onboarding: Routes("Onboarding_screen")

}