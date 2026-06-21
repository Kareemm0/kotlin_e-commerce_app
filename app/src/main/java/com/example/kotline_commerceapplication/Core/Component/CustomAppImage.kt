package com.example.kotline_commerceapplication.Core.Component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

@Composable
fun CustomAppImage(
    image: Int,
    description: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
fun CustomAppImage(
    image: String,
    description: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.None
) {
    AsyncImage(
        model = image,
        contentDescription = description,
        modifier = modifier,
        contentScale = contentScale
    )
}