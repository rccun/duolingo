package com.example.test.language_select


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
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
fun LanguageSelectScreen(
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
            top = (height * 90 / 812).dp,
            start = (width * 24 / 375).dp,
            end = (width * 24 / 375).dp
        )
    ) {
        Text(
            "What is your Mother language?",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            color = Color(0xFF080E1E)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = (height * 16 / 812).dp)
            ,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF76400)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                "Russian",
                modifier = Modifier
                    .padding(
                        start = (width * 15 / 375).dp,
                        top = (height * 20 / 812).dp,
                        bottom = (height * 20 / 812).dp
                    )
                    .fillMaxWidth(),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = (height * 22 / 812).sp,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
        }
    }
}