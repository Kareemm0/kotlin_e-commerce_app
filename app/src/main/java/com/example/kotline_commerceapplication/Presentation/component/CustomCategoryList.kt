package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable
fun CustomCategoryList(
    itemCount: Int,
    categoryImage: Int,
    categoryText: String,
    onClick: () -> Unit,

    ) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        repeat(itemCount) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(80.dp)
                        .background(
                            shape = CircleShape, color = AppColors.transparent
                        )
                        .clickable {
                            onClick()
                        }
                ) {
                    CustomAppImage(
                        image = categoryImage,
                        description = "Category",
                        modifier = Modifier.clip(
                            shape = CircleShape
                        )

                    )
                }

                Text(text = categoryText, fontSize = 16.sp, color = AppColors.primaryColor)
            }
        }
    }
}
