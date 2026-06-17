package com.example.kotline_commerceapplication.Core.Component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable

fun CustomAppImage(
    image: Int,
    description: String?,
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.Fit

) {
    Image(
        painterResource(image), description,
        modifier = modifier,
        contentScale = contentScale
    )
}
