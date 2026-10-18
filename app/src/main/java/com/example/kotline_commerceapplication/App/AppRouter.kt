package com.example.kotline_commerceapplication.App

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotline_commerceapplication.Data.OnBoardingModel
import com.example.kotline_commerceapplication.Presentation.Layout.MainScreen
import com.example.kotline_commerceapplication.Presentation.Screens.ForgetPasswordScreen
import com.example.kotline_commerceapplication.Presentation.Screens.LoginScreen
import com.example.kotline_commerceapplication.Presentation.Screens.OnboardingScreen
import com.example.kotline_commerceapplication.Presentation.Screens.ResetPasswordScreen
import com.example.kotline_commerceapplication.Presentation.Screens.SignUpScreen
import com.example.kotline_commerceapplication.Presentation.Screens.SplashScreen
import com.example.kotline_commerceapplication.Presentation.Screens.VerificationOTPScreen

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
        composable(Routes.Main.route){ MainScreen() }
        composable(Routes.Verification.route , arguments = listOf(
            navArgument("email"){
                type = NavType.StringType
            }
        )) { email ->
val email = email.arguments?.getString("email")
            VerificationOTPScreen(email = email.orEmpty()) }
    }
}