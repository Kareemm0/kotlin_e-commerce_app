package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Extensions.W
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable
fun IndicatorComponent(
    pageSize: Int ,
    currentPage: Int ,

){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
    ){

        repeat(pageSize){
            6.W
            Box(
                modifier = Modifier.height(14.dp).width(
                    if(it == currentPage) 36.dp else 14.dp
                ).clip(
                    RoundedCornerShape(16.dp)
                ).background(
                    if (it == currentPage) AppColors.primaryColor else AppColors.unSelectedItem,

                )
            )
        }
    }
}