package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.Presentation.component.OTPDigit

@Composable
fun VerificationOTPScreen(
    email: String
)


{
    val  otpState = rememberTextFieldState()
    Column(
        modifier = Modifier.padding(vertical = 40.dp , horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),


    ){

        AuthHeaderText(title = "Verification Code ")
        Text("Enter OTP Send TO $email")
        BasicTextField(
           state  =  otpState ,

            modifier = Modifier.semantics{
                contentType = ContentType.SmsOtpCode
            }
            ,
            inputTransformation = InputTransformation.maxLength(6) ,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ) ,
            lineLimits = TextFieldLineLimits.SingleLine ,
            decorator = {
                val otpCode =otpState.text.toString()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
repeat(6){index -> OTPDigit(
    otpCode = otpCode.getOrElse(index) {' '} ,
    isSelected = index == otpState.text.length
) }
                }
            }
        )
        Text("Resend OTP" , modifier = Modifier.align(alignment = Alignment.End).clickable{
            println()
        })

        CustomAppButton(
            onClick = {} ,
            text = "Verify" ,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
@Preview
fun VerificationOTPScreenPreview(){
    VerificationOTPScreen("kareem@gmail.com")
}




