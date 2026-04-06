package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun AuthHeaderText(
     title : String,
     fontSize : TextUnit = 20.0.sp

){
    Text(title, fontSize =fontSize , fontWeight = FontWeight.W700)
}