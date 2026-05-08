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
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.Presentation.component.CustomTextFormFiled
import com.example.kotline_commerceapplication.R

@Composable
fun ForgetPasswordScreen() {
    var email by remember { mutableStateOf("") }
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
            "Forget Password ?"
        )
        30.H
        CustomAppImage(
            R.drawable.forgetpassword, "", Modifier
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
        30.H
        CustomAppButton({}, text = "Submit")
    }
}