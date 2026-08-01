package com.example.kotline_commerceapplication.Presentation.Screens

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.Presentation.component.CustomAuthText
import com.example.kotline_commerceapplication.Presentation.component.CustomTextFormFiled

@Composable
fun SignUpScreen(
    controller: NavController
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var isEmailError by remember { mutableStateOf("") }
    var isPasswordError by remember { mutableStateOf("") }
    var isFirstNameError by remember { mutableStateOf("") }
    var isLastNameError by remember { mutableStateOf("") }

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
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            /// First Name Field
            CustomTextFormFiled(
                isError = isFirstNameError.isNotEmpty(),
                value = firstName,
                onValueChange = {
                    firstName = it
                },
                placeholder = {
                    Text("First Name")
                },
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(),

                supportingText = {
                    if (isFirstNameError.isNotEmpty()) {
                        Text(
                            text = isFirstNameError,
                            color = AppColors.red
                        )
                    }
                }

            )
            /// Last Name Field
            CustomTextFormFiled(
                value = lastName,
                onValueChange = {
                    lastName = it
                },
                placeholder = {
                    Text("Last Name")
                },
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(),
                isError = isLastNameError.isNotEmpty(),
                supportingText = {
                    if (isLastNameError.isNotEmpty()) {
                        Text(
                            text = isLastNameError,
                            color = AppColors.red
                        )
                    }
                }

            )

        }
        16.H
        /// Email Field
        CustomTextFormFiled(
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text("Email Address")
            },
            isError = isEmailError.isNotEmpty(),
            supportingText = {
                if (isEmailError.isNotEmpty()) {
                    Text(
                        text = isEmailError,
                        color = AppColors.red
                    )
                }
            }
        )
        16.H
        /// Password Felid
        CustomTextFormFiled(
            isPassword = false,
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text("Password")
            },
            isError = isPasswordError.isNotEmpty(),
            supportingText = {
                if (isPasswordError.isNotEmpty()) {
                    Text(
                        text = isPasswordError,
                        color = AppColors.red
                    )
                }
            }

        )


        30.H
        CustomAppButton(onClick = {
            isFirstNameError =
                if (firstName.isBlank()) {
                    "First Name is required"
                } else {
                    ""
                }
            isLastNameError =
                if (lastName.isBlank()) {
                    "Last Name is required"
                } else {
                    ""
                }
            isEmailError =
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    "Email is required"
                } else {
                    ""
                }
            isPasswordError =
                if (password.length < 8) {
                    "Password must be at least 8 characters"
                } else {
                    ""
                }


        }, text = "Sign Up ", modifier = Modifier.fillMaxWidth())
        30.H
        CustomAuthText(isLogin = false, navigatorController = controller)
    }

}