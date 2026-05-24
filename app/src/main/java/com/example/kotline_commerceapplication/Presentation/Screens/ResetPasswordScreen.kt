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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotline_commerceapplication.App.Routes
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.Presentation.component.CustomTextFormFiled
import com.example.kotline_commerceapplication.R

@Composable

fun ResetPasswordScreen(
    navController: NavController
){

    var password  by remember { mutableStateOf("") }
    var confirmPassword  by remember { mutableStateOf("") }

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
            "Enter New Password "
        )
        30.H
        CustomAppImage(
            R.drawable.reset_password, "", Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        16.H
        /// Password Filed
        CustomTextFormFiled(
            password,
            onValueChange = { password = it },
            placeholder = {
                Text("Enter New Password ")
            },
        )
        16.H
        CustomTextFormFiled(
            confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = {
                Text("Confirm New Password ")
            },
        )
        30.H
        CustomAppButton({
            navController.navigate(Routes.Login.route)
        }, text = "Submit",modifier = Modifier.fillMaxWidth())
    }
}