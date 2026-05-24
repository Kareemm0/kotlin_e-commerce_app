package com.example.kotline_commerceapplication.App

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotline_commerceapplication.Data.OnBoardingModel
import com.example.kotline_commerceapplication.Presentation.Screens.ForgetPasswordScreen
import com.example.kotline_commerceapplication.Presentation.Screens.LoginScreen
import com.example.kotline_commerceapplication.Presentation.Screens.OnboardingScreen
import com.example.kotline_commerceapplication.Presentation.Screens.ResetPasswordScreen
import com.example.kotline_commerceapplication.Presentation.Screens.SignUpScreen
import com.example.kotline_commerceapplication.Presentation.Screens.SplashScreen

@Composable
fun AppRouter(){
    val navController = rememberNavController()

    NavHost(navController = navController ,startDestination = Routes.Splash.route){
        composable(route = Routes.Login.route){ LoginScreen(navController) }
        composable(route = Routes.SignUp.route){ SignUpScreen(navController) }
        composable(route = Routes.ForgetPassword.route){ ForgetPasswordScreen(navController )}
        composable(Routes.ResetPassword.route){ ResetPasswordScreen(navController) }
        composable(Routes.Splash.route){ SplashScreen(navController) }
        composable(Routes.Onboarding.route){ OnboardingScreen(navController) }
    }
}