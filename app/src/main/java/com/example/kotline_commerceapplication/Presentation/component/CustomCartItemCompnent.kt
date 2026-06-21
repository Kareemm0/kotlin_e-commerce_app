package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Core.Utils.AppColors

@Composable
fun CustomCartItemComponent(
    image: Int,
    favoriteOnClick: () -> Unit,
    addOnClick: () -> Unit,
    productName: String,
    productDescription: String,
    productPrice: String,
    productImageDescription: String,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    itemCount: String,
) {
    Box(
        modifier = Modifier
            .background(color = AppColors.darkWhite)
            .clip(
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 4.dp),
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomProductItem(isShown = false)
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .border(
                            width = 2.dp,
                            color = AppColors.primaryColor,
                            shape = RoundedCornerShape(24.dp)
                        )
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        IconButton(
                            onClick = onIncrement
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Item"
                            )
                        }

                        Text(
                            text = itemCount,
                            fontSize = 20.sp
                        )

                        IconButton(
                            onClick = onDecrement
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Remove Item"
                            )
                        }
                    }
                }

            }
        }
    )
}
