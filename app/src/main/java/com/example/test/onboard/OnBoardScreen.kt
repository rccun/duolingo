package com.example.test.onboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.R
import com.example.test.Route

@Composable
fun OnBoardScreen(
    navController: NavController
) {

    val fonts = FontFamily(
        Font(R.font.fredoka_m, FontWeight.Medium),
        Font(R.font.fredoka_r, FontWeight.Normal)
    )
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp
    Column(
        modifier = Modifier.padding(
            top = (height * 147 / 812).dp,
            start = (width * 24 / 375).dp,
            end = (width * 24 / 375).dp
        )
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.onb1),
            "blabla",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height((height * 220.26 / 812).dp)
                .width((width * 240 / 375).dp),

            contentScale = ContentScale.Fit

        )
        Spacer(modifier = Modifier.height((height * 114.74 / 812).dp))

        Row(modifier = Modifier.height((height * 8 / 812).dp)) {
            Canvas(modifier = Modifier.fillMaxHeight()) {
                drawCircle(
                    color = Color(0xFFF76400),
                    center = Offset(0f, 0f)
                )
            }
        }
        Text(
            "Confidence in your words",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            color = Color(0xFF080E1E),
            modifier = Modifier
                .padding(top = (height * 40 / 812).dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            "With conversation-based learning, you'll be talking from lesson one",
            color = Color(0x60080E1E),
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(
                    top = (height * 8 / 812).dp,
                    bottom = (height * 50 / 812).dp,
                    start = (width * 32 / 375).dp, end = (width * 32 / 375).dp
                )
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { navController.navigate(Route.OnBoard2.route) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .background(color = Color(0xFF5B7BFE), shape = RoundedCornerShape(12.dp))
        ) {
            Text(
                "Next",
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
                .clickable { navController.navigate(Route.OnBoard3.route) }
                .padding(top = (height * 16 / 812).dp)
                .align(Alignment.CenterHorizontally)
        )

    }

}