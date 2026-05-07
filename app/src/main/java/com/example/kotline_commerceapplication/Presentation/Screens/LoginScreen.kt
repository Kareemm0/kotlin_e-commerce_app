package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Presentation.component.AuthHeaderText
import com.example.kotline_commerceapplication.R

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
        CustomAppImage( R.drawable.login ,  "" , Modifier.fillMaxSize())

    }
}
