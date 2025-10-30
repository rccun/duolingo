package com.example.duolingo.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.presentation.Route
import com.example.duolingo.fonts

@Composable
fun ResizePhotoScreen(navController: NavController) {

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF410FA3))
                .padding(horizontal = (width * 24 / 375).dp)
        )
        {
            Text(
                stringResource(R.string.resize_title),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = (height * 22 / 812).sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        top = (height * 59 / 812).dp,
                        bottom = (height * 17 / 812).dp
                    )
            )
        }
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .weight(1f)
        ) {

        }
        Button(
            onClick = { navController.navigate(Route.Profile) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(
                    bottom = (height * 24 / 812).dp,
                    start = (width * 24 / 375).dp,
                    end = (width * 24 / 375).dp
                )
                .height((height * 56 / 812).dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                stringResource(R.string.btn_use),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
    }
}