package com.example.kotline_commerceapplication.Core.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable
fun CustomAppButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier ,
    textColor: Color = AppColors.whiteColor ,
    containerColor: Color = AppColors.primaryColor
) {

    Button(
        modifier = modifier,
        contentPadding = PaddingValues( vertical = 12.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor
        ),
        onClick = onClick,
        enabled = true,
    ) {
        Text(
            text = text,
            color = textColor, fontSize = 18.sp, fontWeight = FontWeight.W700,
        )
    }
}