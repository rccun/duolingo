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
fun ExerciseAvatar(url: String, modifier: Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = "Exercise avatar",
        contentScale = ContentScale.FillHeight,
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.login),
        modifier = modifier
    )
}
