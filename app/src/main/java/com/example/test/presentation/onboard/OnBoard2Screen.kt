package com.example.test.presentation.onboard

import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.layout.heightIn
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.test.R
import com.example.test.Route
import com.example.test.fonts

data class OnBoard2Screen(
    @DrawableRes val id: Int,
    val title: String,
    val desc: String,
)

@Composable
fun OnBoard2Screen(
    navController: NavController,
    viewModel: OnBoardViewModel = hiltViewModel()
) {


    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    Column(
        modifier = Modifier
            .padding(horizontal = 25.dp)
    ) {
        Spacer(Modifier.weight(2f))
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.onb2),
            "onb2",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height((height * 256.63 / 812).dp)
                .width((width * 215 / 375).dp),

            contentScale = ContentScale.Fit

        )
        Spacer(Modifier.weight(1.5f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                (width * 8 / 375).dp,
                Alignment.CenterHorizontally
            )
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
                    .background(Color(0xFFF76400), CircleShape)
            )
            Box(
                Modifier
                    .size((width * 8 / 375).dp)
                    .clip(CircleShape)
                    .background(Color(0x20080E1E), CircleShape)
            )
        }

        Spacer(Modifier.height(40.dp))
        Text(
            "Take your time to learn",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            color = Color(0xFF080E1E),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            "Develop a habit of learning and make it a part of your daily routine",
            color = Color(0x60080E1E),
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.weight(0.2f))
        Button(
            onClick = { viewModel.onEvent(OnBoardEvent.OnNextButtonClick(2)) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .heightIn(55.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "More",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
        Spacer(Modifier.height(15.dp))
        Text(
            "Skip onboarding",
            color = Color(0xFF080E1E),
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier
                .clickable { navController.navigate(Route.LanguageSelect.route) }
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.weight(0.5f))

    }

}