package com.example.kotline_commerceapplication.Presentation.Layout

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kotline_commerceapplication.App.Routes
import com.example.kotline_commerceapplication.Core.Enums.BottomNavigationBarEnum
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.Presentation.Screens.CartScreen
import com.example.kotline_commerceapplication.Presentation.Screens.FavoriteScreen
import com.example.kotline_commerceapplication.Presentation.Screens.HomeScreen
import com.example.kotline_commerceapplication.Presentation.Screens.SettingsScreen

@Composable

fun MainScreen(

) {
    val navController = rememberNavController()
    val navBar by navController.currentBackStackEntryAsState()
    val currentRoute = navBar?.destination?.route
    Scaffold(
        content = {

                paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Routes.Home.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(route = Routes.Home.route) { HomeScreen() }
                composable(route = Routes.Cart.route) { CartScreen() }
                composable(route = Routes.Favorite.route) { FavoriteScreen() }
                composable(route = Routes.Settings.route) { SettingsScreen() }

            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = AppColors.transparent

            ) {

                BottomNavigationBarEnum.entries.forEachIndexed { index, enum ->

                    val selected = currentRoute == enum.route

                    NavigationBarItem(
                        label = {
                            Text(text = enum.label, fontSize = 18.sp)
                        },
                        icon = {
                            Icon(
                                imageVector = enum.icon,
                                contentDescription = enum.label
                            )
                        },
                        selected = selected,
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = AppColors.primaryColor,
                            selectedIconColor = AppColors.whiteColor,
                            selectedTextColor = AppColors.primaryColor

                        ),
                        onClick = {
                            if (
                                currentRoute != enum.route
                            ) {
                                navController.navigate(enum.route) {
                                    popUpTo(Routes.Main.route) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },

                        )
                }


            }
        }
    )
}
