package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Component.CustomBoxIcon
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Core.Extensions.W

@Composable
fun CustomProductItem(
    productImage: Int,
    productImageDescription: String,
    favoriteOnClick: () -> Unit,
    addOnClick: () -> Unit,
    productName: String,
    productDescription: String,
    productPrice: String

) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(150.dp),
            content = {
                CustomAppImage(
                    productImage,
                    description = productImageDescription,
                    modifier = Modifier.clip(
                        shape = RoundedCornerShape(16.dp)
                    )

                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    CustomBoxIcon(
                        icon = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        onClick = {
                            favoriteOnClick()
                        }
                    )
                    CustomBoxIcon(
                        icon = Icons.Outlined.Add,
                        contentDescription = "Add",
                        onClick = {
                            addOnClick()
                        }
                    )

                }
            }

        )
        16.W
        Column(
            Modifier.padding(top = 24.dp)
        ) {
            Text(productName, fontSize = 18.sp)
            8.H
            Text(productDescription, fontSize = 16.sp)
            8.H
            Text("$productPrice EG", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

    }
}