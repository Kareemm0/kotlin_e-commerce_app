package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.Presentation.component.CustomSettingComponent
import com.example.kotline_commerceapplication.Presentation.component.CustomTopBar

@Composable

fun SettingsScreen() {
    Scaffold(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
        topBar = {
            CustomTopBar(title = "Settings Screen")
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                16.H
                CustomSettingComponent(
                    title = "Account",
                    onClick = {}
                )
                16.H
                CustomSettingComponent(
                    title = "Terms and Conditions",
                    onClick = {}
                )
                16.H
                CustomSettingComponent(
                    title = "Privacy Policy",
                    onClick = {}
                )
                16.H
                CustomSettingComponent(
                    title = "About Us",
                    onClick = {}
                )
                16.H

                CustomSettingComponent(
                    title = "Change Language",
                    onClick = {}
                )
                16.H
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Dark Mode", fontSize = 20.sp)
                    Switch(
                        onCheckedChange = {},
                        checked = false
                    )
                }
                150.H
                CustomAppButton(
                    text = "Logout",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = AppColors.red
                )
            }
        }
    )
}
