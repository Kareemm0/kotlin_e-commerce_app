package com.example.kotline_commerceapplication.Core.Enums

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.kotline_commerceapplication.App.Routes

enum class BottomNavigationBarEnum(
    val label: String,
    val icon: ImageVector,
    val route: String,
) {
    HomeScreen("Home", Icons.Default.Home, Routes.Home.route),
    CartScreen("Cart", Icons.Default.ShoppingCart, Routes.Cart.route),
    FavoriteScreen("Favorite", Icons.Default.Favorite, Routes.Favorite.route),
    SettingsScreen("Settings", Icons.Default.Settings, Routes.Settings.route),

}