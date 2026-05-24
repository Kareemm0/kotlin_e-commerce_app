package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.Presentation.component.CustomAuthText
import com.example.kotline_commerceapplication.Presentation.component.CustomTextFormFiled

@Composable
fun SignUpScreen(
    controller: NavController
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(
                vertical = 40.dp, horizontal = 16.dp
            )
    ) {
        AuthHeaderText("Create A New Account ")
        30.H
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
        16.H
        /// Confirm Password Felid
        CustomTextFormFiled(
            confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = {
                Text("Confirm Password")
            },
        )
        30.H
        CustomAppButton(onClick = {} , text = "Sign Up ",modifier = Modifier.fillMaxWidth())
        30.H
        CustomAuthText(isLogin = false , navigatorController = controller)
    }

}