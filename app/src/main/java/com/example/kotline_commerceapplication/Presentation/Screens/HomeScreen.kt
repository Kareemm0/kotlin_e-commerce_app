package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.CustomHomTopBarComponent
import com.example.kotline_commerceapplication.Presentation.component.CustomTextFormFiled

@Composable

fun HomeScreen() {

    Scaffold(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
        topBar = {
            CustomHomTopBarComponent(
                "Kareem",
                notificationsCount = 4
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                24.H
                CustomTextFormFiled(
                    label = {
                        Text("Search")
                    },
                    value = "",
                    onValueChange = {}
                )
            }
        }
    )
}