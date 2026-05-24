package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotline_commerceapplication.App.Routes
import com.example.kotline_commerceapplication.Core.Component.CustomAppButton
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Core.Utils.AppColors
import com.example.kotline_commerceapplication.Data.OnBoardingModel
import com.example.kotline_commerceapplication.Presentation.component.IndicatorComponent
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(navController: NavController) {
    val pages =  OnBoardingModel.pages()
    val pageStatus = rememberPagerState(
        initialPage = 0,
        pageCount = { OnBoardingModel.pages().size }
    )
    val scop  = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 40.dp),
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CustomAppButton(
                    onClick = {
                        scop.launch {
                            if (pageStatus.currentPage > 0) {
                                pageStatus.animateScrollToPage(
                                    pageStatus.currentPage - 1
                                )
                            }
                        }
                    },
                    text = "Back",
                    modifier = Modifier,
                    containerColor = AppColors.transparent,
                    textColor =
                        if (pageStatus.currentPage == 0)
                            AppColors.transparent
                        else
                            AppColors.primaryColor
                )
                IndicatorComponent(pageSize = pages.size, currentPage = pageStatus.currentPage)
                CustomAppButton(
                    onClick = {
                        scop.launch {
                            if (pageStatus.currentPage < pages.size - 1){
                                pageStatus.animateScrollToPage(pageStatus.currentPage + 1)
                            }
                            else{
                                navController.navigate(Routes.Login.route)
                            }
                        }
                    },
                    text = if (pageStatus.currentPage == pages.lastIndex)
                        "Start"
                    else
                        "Next",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                HorizontalPager(
                    state = pageStatus,
                    modifier = Modifier.weight(1f)
                ) { index ->
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CustomAppButton(
                            onClick = {
                                navController.navigate(Routes.Login.route)
                            }  ,
                            text = "Skip" ,
                            modifier = Modifier.align(Alignment.Start).fillMaxWidth(fraction = 0.3f) ,
                            textColor = AppColors.primaryColor,
                            containerColor = AppColors.transparent
                        )
                        CustomAppImage(
                         modifier =    Modifier.size(400.dp),
                            image = pages[index].image,
                            description = "",
                        )
                        16.H
                        Text(
                            text = pages[index].title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700
                        )
                        16.H
                        Text(
                            text = pages[index].description,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500 ,
                            color = AppColors.primaryColor ,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}

