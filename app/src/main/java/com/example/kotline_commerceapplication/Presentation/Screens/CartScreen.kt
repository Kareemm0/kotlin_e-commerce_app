package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.CustomCartItemComponent
import com.example.kotline_commerceapplication.Presentation.component.CustomTopBar
import com.example.kotline_commerceapplication.R

@Composable

fun CartScreen() {
    Scaffold(
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    )

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("sub Total")
                    Text("$100")
                }
                16.H
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Shipping")
                    Text("$100")
                }
                16.H
                CustomAppButton(
                    text = "Checkout",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )

            }
        },
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
        topBar = {
            CustomTopBar(title = "Cart")
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(10) {
                    CustomCartItemComponent(
                        image = R.drawable.product,
                        addOnClick = {},
                        favoriteOnClick = {},
                        onDecrement = {},
                        onIncrement = {},
                        productName = "Product Name",
                        productDescription = "Product Description",
                        productPrice = "Product Price",
                        productImageDescription = "Product Image",
                        itemCount = "1"
                    )
                }

            }

        }
    )
}
