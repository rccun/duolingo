package com.example.duolingo.presentation.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.Route
import com.example.duolingo.fonts


@Composable
fun OnBoard3Screen(
    navController: NavController
) {

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    Column(
        modifier = Modifier.padding(
            top = (height * 140 / 812).dp,
            start = (width * 24 / 375).dp,
            end = (width * 24 / 375).dp
        )
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.onb3),
            "onb2",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height((height * 234.62 / 812).dp)
                .width((width * 215 / 375).dp),

            contentScale = ContentScale.Fit

        )
        Spacer(modifier = Modifier.height((height * 107.38 / 812).dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy((width * 8 / 375).dp, Alignment.CenterHorizontally)
        ) {
            Box(
                Modifier
                    .size((width * 8 / 375).dp)
                    .clip(CircleShape)
                    .background(Color(0x20080E1E), CircleShape)
            )
            Box(
                Modifier
                    .size((width * 8 / 375).dp)
                    .clip(CircleShape)
                    .background(Color(0x20080E1E), CircleShape)
            )
            Box(
                Modifier
                    .size((width * 8 / 375).dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF76400), CircleShape)
            )
        }
        Text(
            "",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            color = Color(0xFF080E1E),
            modifier = Modifier
                .padding(top = (height * 40 / 812).dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            "",
            color = Color(0x60080E1E),
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(
                    top = (height * 8 / 812).dp,
                    bottom = (height * 50 / 812).dp,
                    start = (width * 41 / 375).dp, end = (width * 41 / 375).dp
                )
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { navController.navigate(Route.LanguageSelect.route) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
        Text(
            "Skip onboarding",
            color = Color(0xFF080E1E),
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier
                .clickable { navController.navigate(Route.LanguageSelect.route) }
                .padding(top = (height * 16 / 812).dp)
                .align(Alignment.CenterHorizontally)
        )

    }

}