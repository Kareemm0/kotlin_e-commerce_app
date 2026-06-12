package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.kotline_commerceapplication.Core.Extensions.W
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.R

@Composable
fun CustomHomTopBarComponent(
    name: String,
    notificationsCount: Int? = 0
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            R.raw.person
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(
                    color = AppColors.transparent,
                    shape = CircleShape
                )
                .border(
                    color = AppColors.primaryColor,
                    width = 2.dp,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center,
            content = {
                LottieAnimation(
                    composition = composition,
                    modifier = Modifier.size(80.dp),
                    iterations = LottieConstants.IterateForever
                )
            }

        )
        8.W
        Text(
            text = "Hi $name",
            color = AppColors.primaryColor,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        BadgedBox(

            badge = {
                Badge(
                    content = {
                        Text("$notificationsCount")
                    }
                )
            },
            content = {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = AppColors.primaryColor,
                )
            }
        )

    }


}
