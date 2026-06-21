package com.example.kotline_commerceapplication.Presentation.Screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.kotline_commerceapplication.Core.Component.CustomAppImage
import com.example.kotline_commerceapplication.Core.Extensions.H
import com.example.kotline_commerceapplication.Presentation.component.CustomCategoryList
import com.example.kotline_commerceapplication.Presentation.component.CustomHomTopBarComponent
import com.example.kotline_commerceapplication.Presentation.component.CustomProductItem
import com.example.kotline_commerceapplication.Presentation.component.CustomTextFormFiled
import com.example.kotline_commerceapplication.R
import kotlinx.coroutines.delay

@Composable

fun HomeScreen() {


    val banners = listOf(R.drawable.banner, R.drawable.banner, R.drawable.banner)
    val bannerCount = banners.size


    val pagerState =
        rememberPagerState(initialPage = 0, pageCount = { bannerCount })


    LaunchedEffect(Unit) {

        while (true) {
            delay(3000)

            val nextPage = (pagerState.currentPage + 1) % banners.size

            pagerState.animateScrollToPage(nextPage)
        }


    }
    Scaffold(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
        topBar = {
            CustomHomTopBarComponent(
                "Kareem",
                notificationsCount = 4
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)

            ) {
                item {
                    CustomTextFormFiled(
                        label = {
                            Text("Search")
                        },
                        value = "",
                        onValueChange = {}
                    )
                }
                item { 16.H }
                item {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxWidth()

                    ) { index ->
                        CustomAppImage(
                            banners[index],
                            description = "banner",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp)
                                .clip(
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            contentScale = ContentScale.FillWidth
                        )
                    }

                }
                item() {
                    CustomCategoryList(
                        itemCount = 10,
                        categoryImage = R.drawable.category,
                        categoryText = "Category",
                        onClick = {}
                    )
                }
                item { 16.H }
                item {
                    CustomProductItem()
                }
            }


        }
    )
}

