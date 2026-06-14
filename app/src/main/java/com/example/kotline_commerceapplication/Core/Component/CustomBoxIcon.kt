package com.example.kotline_commerceapplication.Core.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable
fun CustomBoxIcon(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .size(30.dp)
            .background(
                color = AppColors.whiteColor,
                shape = CircleShape
            )
            .clickable {
                onClick()
            }

    ) {
        Icon(
            icon,
            contentDescription = contentDescription,
            tint = AppColors.primaryColor


        )

    }
}
