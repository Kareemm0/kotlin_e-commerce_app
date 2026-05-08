package com.example.kotline_commerceapplication.App

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotline_commerceapplication.Presentation.Screens.LoginScreen
import com.example.kotline_commerceapplication.Presentation.Screens.SignUpScreen

@Composable
fun AppRouter(){
    val navController = rememberNavController()

    NavHost(navController = navController ,startDestination = Routes.Login.route){
        composable(route = Routes.Login.route){ LoginScreen(navController) }
        composable(route = Routes.SignUp.route){ SignUpScreen() }
    }
}