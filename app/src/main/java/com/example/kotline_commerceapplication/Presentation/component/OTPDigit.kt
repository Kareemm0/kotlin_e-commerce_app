package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable
fun OTPDigit(
    otpCode: Char,
    isSelected: Boolean
){

    val borderColor by animateColorAsState(
        targetValue = if(isSelected) AppColors.primaryColor else AppColors.black
    )
    val borderSize by animateDpAsState(
        targetValue = if(isSelected) 3.dp else 1.dp
    )


    Box(
        modifier = Modifier.size(48.dp).border(
            borderSize , borderColor , RoundedCornerShape(4.dp)
        )
    ){
        Text(
            text = otpCode.toString(),
            fontSize = 24.sp ,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}