package com.example.duolingo.presentation.onboard

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.presentation.Route
import com.example.duolingo.fonts

data class OnBoardScreen(
    @DrawableRes val img: Int,
    val title: String,
    val desc: String,
    val btnText: String,
)


@Composable
fun OnBoardScreen(
    navController: NavController
) {


    val ind = remember { mutableStateOf(0) }


    val list = listOf(

        OnBoardScreen(
            R.drawable.onb1,
            stringResource(R.string.onb1),
            stringResource(R.string.onb1desc),
            stringResource(R.string.btn_next)
        ),
        OnBoardScreen(
            R.drawable.onb2,
            stringResource(R.string.onb2),
            stringResource(R.string.onb2desc),
            stringResource(R.string.onb2btn)
        ),
        OnBoardScreen(
            R.drawable.onb3,
            stringResource(R.string.onb3),
            stringResource(R.string.onb3desc),
            stringResource(R.string.onb3btn)
        ),
    ) //147

    Column(
        modifier = Modifier
            .padding(horizontal = 25.dp)
    ) {
        Spacer(Modifier.weight(2f))

        Column (modifier = Modifier
            .align(Alignment.CenterHorizontally)

            .fillMaxHeight(0.3f)
        )
        {
            Image(
                bitmap = ImageBitmap.imageResource(list[ind.value].img),
                "onb1",
                modifier = Modifier
                    .fillMaxHeight(),
                contentScale = ContentScale.FillHeight

            )
        }

        Spacer(Modifier.weight(1.5f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                8.dp,
                Alignment.CenterHorizontally
            )
        ) {
            repeat(list.size) { i ->
                Box(
                    Modifier
                        .size( 8.dp)
                        .clip(CircleShape)
                        .background(
                            if (i == ind.value) Color(0xFFF76400)
                            else Color(0x20080E1E)
                        )
                )
            }
        }
        Spacer(Modifier.height(40.dp))
        Text(
            list[ind.value].title,
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            color = Color(0xFF080E1E),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            list[ind.value].desc,
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
            onClick = {
                if (ind.value < 2) ind.value++
                else navController.navigate(Route.LanguageSelect)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                list[ind.value].btnText,
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
        Spacer(Modifier.height(15.dp))
        Text(
            stringResource(R.string.onb_skip),
            color = Color(0xFF080E1E),
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier
                .clickable { navController.navigate(Route.LanguageSelect) }
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.weight(0.5f))
    }
}

