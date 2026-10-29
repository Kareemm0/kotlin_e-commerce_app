package com.example.kotline_commerceapplication.Presentation.Screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.Presentation.ViewModel.OTPViewModel.OTPState
import com.example.kotline_commerceapplication.Presentation.ViewModel.OTPViewModel.OTPViewModel
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.Presentation.component.OTPDigit
import kotlinx.coroutines.delay


@Composable
fun VerificationOTPScreen(
    email: String
) {
    val otpState = rememberTextFieldState()
    val duration: Int = 60
    var timer by remember { mutableIntStateOf(duration) }
    var isClickable by remember { mutableStateOf(false) }
    val otpViewModel: OTPViewModel = viewModel()
    val resendOtpState by otpViewModel.resendOTPState.collectAsState()
    val context = LocalContext.current

    // Resend OTP Counter
    LaunchedEffect(duration) {
        timer = duration
        isClickable = false
        while (timer > 0) {
            delay(1000L)
            timer--
        }
        isClickable = true

       when (val state = resendOtpState){
           is OTPState.ResendOTPSuccessState -> {
           Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()


           }else -> {}
       }
    }
    Column(
        modifier = Modifier.padding(vertical = 40.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        AuthHeaderText(title = "Verification Code ")
        Text("Enter OTP Send TO $email")
        BasicTextField(
            state = otpState,

            modifier = Modifier.semantics {
                contentType = ContentType.SmsOtpCode
            },
            inputTransformation = InputTransformation.maxLength(6),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            decorator = {
                val otpCode = otpState.text.toString()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    repeat(6) { index ->
                        OTPDigit(
                            otpCode = otpCode.getOrElse(index) { ' ' },
                            isSelected = index == otpState.text.length
                        )
                    }
                }
            }
        )
        if (resendOtpState is OTPState.ResendOTPLoadingState) {
            CircularProgressIndicator(
                modifier = Modifier.size(16.dp) .align(Alignment.End),
                strokeWidth = 2.dp
            )

            Text(
                text = "Sending...",
                        modifier = Modifier
                        .align(Alignment.End)
            )
        } else {
            Text(
                text = if (isClickable) "Resend OTP" else "Resend OTP in ${timer}s",
                color = if (isClickable) AppColors.primaryColor else AppColors.black,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(enabled = isClickable) {

                            if (email.isEmpty()) {
                                Toast.makeText(context, "Invalid Email", Toast.LENGTH_LONG).show()

                            } else {
                                otpViewModel.resendOTP(email = email)
                            }

                    }

            )
        }

        CustomAppButton(
            onClick = {},
            text = "Verify",
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
@Preview
fun VerificationOTPScreenPreview() {
    VerificationOTPScreen("kareem@gmail.com")
}




