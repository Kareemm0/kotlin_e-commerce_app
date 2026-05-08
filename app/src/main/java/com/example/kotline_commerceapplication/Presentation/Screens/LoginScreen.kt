package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.Presentation.component.CustomAuthText
import com.example.kotline_commerceapplication.Presentation.component.CustomTextFormFiled
import com.example.kotline_commerceapplication.R

@Composable
fun LoginScreen(
    controller: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(
                vertical = 40.dp, horizontal = 16.dp
            )
    ) {
        AuthHeaderText(
            "Welcome Back , Sign In "
        )
        24.H
        CustomAppImage(
            R.drawable.login, "", Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        16.H
        /// Email Filed
        CustomTextFormFiled(
            email,
            onValueChange = { email = it },
            placeholder = {
                Text("Enter Your Email Address")
            },
        )
        16.H
        /// Password Felid
        CustomTextFormFiled(
            password,
            onValueChange = { password = it },
            placeholder = {
                Text("Enter Your Password")
            },
        )
        30.H
        CustomAppButton({}, text = "Login")
        16.H
        CustomAuthText(navigatorController = controller)

    }
}
