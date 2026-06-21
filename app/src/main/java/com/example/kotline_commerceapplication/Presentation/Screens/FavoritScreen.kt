package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.CustomProductItem
import com.example.kotline_commerceapplication.Presentation.component.CustomTopBar

@Composable

fun FavoriteScreen() {
    Scaffold(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
        topBar = {
            CustomTopBar(title = "Favorites Screen")
        }, content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                item {
                    40.H
                }
                item {
                    CustomProductItem(

                    )
                }

            }
        }
    )

}