package com.example.duolingo.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.presentation.Route


@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    LaunchedEffect(state.isTimeOut) {
        if (state.isTimeOut) {
            navController.navigate(Route.OnBoard)
        }
    }

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF410FA3))
            .padding(top = (height * 250 / 812).dp)
    ) {

        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.splash),
            "blabla",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height((height * 152 / 812).dp)
                .width((width * 164 / 375).dp)
                .padding(bottom = (height * 24 / 812).dp),
            contentScale = ContentScale.Fit

        )
        Text(
            text = stringResource(R.string.splash_title),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.White,
            fontSize = 36.sp
        )
    }
}