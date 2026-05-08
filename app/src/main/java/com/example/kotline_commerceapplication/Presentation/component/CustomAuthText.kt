package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotline_commerceapplication.App.Routes
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable

fun CustomAuthText(
    isLogin: Boolean = true,
    navigatorController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (isLogin) "Don't Have An Account ? " else "Already Have An Account"
        )
        Text(
            if (isLogin) "Sign Up" else "Sign In",
            color = AppColors.primaryColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.clickable(onClick = {
                if (isLogin) navigatorController.navigate(Routes.SignUp.route) else
                    navigatorController.navigate(Routes.Login.route)
            })
        )
    }
}