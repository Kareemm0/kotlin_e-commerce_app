package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.Presentation.component.CustomProductItem
import com.example.kotline_commerceapplication.R

@Composable

fun FavoriteScreen() {
    Scaffold(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
        topBar = {
            Text(
                text = "Favorites Screen",
                color = AppColors.primaryColor,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
            )
        }, content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                item {
                    40.H
                }
                items(100) {
                    CustomProductItem(
                        productImage = R.drawable.product,
                        favoriteOnClick = {},
                        addOnClick = {},
                        productName = "Product Name",
                        productDescription = "Product Description",
                        productPrice = "Product Price",
                        productImageDescription = "Product Image"
                    )
                }

            }
        }
    )

}