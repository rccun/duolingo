package com.example.duolingo.presentation.profile

import android.R.id.primary
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.duolingo.LocalThemeManager
import com.example.duolingo.R
import com.example.duolingo.presentation.Route
import com.example.duolingo.fonts

data class Btn(
    val text: String,
    val action: String,
    val color: Color
)

@Composable
fun ProfileScreen(navController: NavController) {

    val btnText = remember { mutableStateOf("") }
    val themeManager = LocalThemeManager.current
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp
//
//    val btns = listOf<Btn>(
//        Btn(stringResource(R.string.btn_switch), "", Color(0xFF5B7BFE)),
//        Btn(
//            stringResource(R.string.btn_change_lang),
//            "navController.navigate(Route.LanguageSelect.route)",
//            Color(0xFF5B7BFE)
//        ),
//        Btn(
//            stringResource(R.string.btn_change_photo),
//            "navController.navigate(Route.ResizePhoto.route)",
//            Color(0xFF5B7BFE)
//        ),
//        Btn(stringResource(R.string.btn_logout), "navController.navigate(Route.LogIn.route)", Color(0xFFE5E5E5))
//
//    )
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (ref1, ref2) = createRefs()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF410FA3))
                .padding(horizontal = (width * 24 / 375).dp)
                .constrainAs(ref1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                }
        )
        {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.placeholder),
                "avatar",
                modifier = Modifier
                    .padding(
                        top = (height * 44 / 812).dp,
                        bottom = (height * 5 / 812).dp
                    )
                    .height((height * 134 / 812).dp)
                    .width((width * 134 / 375).dp)
            )
            Text(
                stringResource(R.string.your_prof),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = (height * 22 / 812).sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        bottom = (height * 20 / 812).dp
                    )
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy((height * 10 / 812).dp),
            modifier = Modifier.padding(
                start = (width * 24 / 375).dp,
                end = (width * 24 / 375).dp,
                bottom = (height * 24 / 812).dp
            )
                .constrainAs(ref2) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                },
        ) {
            Button(
                onClick = { themeManager.toggleTheme() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height((height * 56 / 812).dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    if (themeManager.isDarkTheme) stringResource(R.string.btn_switch_light)
                            else stringResource(R.string.btn_switch_dark),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Button(
                onClick = {navController.navigate(Route.LanguageSelect)},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height((height * 56 / 812).dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    stringResource(R.string.btn_change_lang),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Button(
                onClick = {navController.navigate(Route.ResizePhoto)},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height((height * 56 / 812).dp),
//                colors = ButtonDefaults.buttonColors(
//                    Color(0xFF5B7BFE)
//                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    stringResource(R.string.btn_change_photo),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                )

            }
            Button(
                onClick = {navController.navigate(Route.LogIn)},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height((height * 56 / 812).dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFE5E5E5)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    stringResource(R.string.btn_logout),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                )

            }
        }
    }
}