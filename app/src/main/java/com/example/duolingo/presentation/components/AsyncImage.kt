package com.example.duolingo.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.duolingo.R

@Composable
fun AsyncImage(url: String, modifier: Modifier, desc: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = desc,
        contentScale = ContentScale.FillHeight,
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.login),
        modifier = modifier
    )
}
