package com.example.kotline_commerceapplication.Presentation.Screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotline_commerceapplication.App.Routes
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.R
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@Composable
fun  SplashScreen(
    navController: NavController
){
    LaunchedEffect(Unit)
    {
        delay(2000)
        navController.navigate(Routes.Login.route)
    }
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()){
        CustomAppImage(R.drawable.app_logo ,"" , Modifier.padding(
            horizontal = 16.dp
        ).fillMaxWidth().fillMaxHeight())
    }
}
