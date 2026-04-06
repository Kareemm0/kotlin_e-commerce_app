package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText

@Composable
fun LoginScreen(

) {
    Column(
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
    }
}
