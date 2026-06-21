package com.example.kotline_commerceapplication.Presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Component.CustomBoxIcon
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Core.Extensions.W
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.Presentation.ViewModel.ProductViewModel.ProductsUiStates
import com.example.kotline_commerceapplication.Presentation.ViewModel.ProductViewModel.ProductsViewModel

@Composable
fun CustomProductItem(
    isShown: Boolean = true
) {

    val vm: ProductsViewModel = viewModel()

    when (val state = vm.uiState) {

        is ProductsUiStates.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = AppColors.primaryColor
                )
            }
        }

        is ProductsUiStates.Error -> {
            Column(
                modifier = Modifier.padding(
                    horizontal = 16.dp, vertical = 20.dp
                ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Something went wrong , Please Try Again")
                16.H
                CustomAppButton(
                    text = "Retry",
                    onClick = { vm.getProducts() }, modifier = Modifier
                )
            }

        }

        is ProductsUiStates.Success -> {

            Column {

                state.products.forEach { product ->

                    Row(
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {

                        Box(
                            modifier = Modifier.height(150.dp)
                        ) {
                            CustomAppImage(
                                image = product.coverPictureUrl,
                                description = "productImageDescription",
                                contentScale = ContentScale.FillHeight,
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(16.dp)
                                    )
                                    .width(100.dp)


                            )

                            if (isShown) {
                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxHeight()
                                ) {

                                    CustomBoxIcon(
                                        icon = Icons.Outlined.FavoriteBorder,
                                        contentDescription = "Favorite",
                                        onClick = {}
                                    )

                                    CustomBoxIcon(
                                        icon = Icons.Outlined.Add,
                                        contentDescription = "Add",
                                        onClick = {}
                                    )
                                }
                            }
                        }

                        16.W

                        Column(
                            modifier = Modifier.padding(top = 24.dp)
                        ) {

                            Text(
                                text = product.name,
                                fontSize = 18.sp
                            )

                            8.H

                            Text(
                                text = product.description,
                                fontSize = 16.sp,
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis
                            )

                            8.H

                            Text(
                                text = "${product.price} EG",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

