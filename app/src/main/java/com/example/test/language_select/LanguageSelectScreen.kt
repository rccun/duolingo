package com.example.test.language_select


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.constraintlayout.widget.ConstraintLayout
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
    val languages = listOf("Russian", "English", "Chinese", "Belarus", "Kazakh")

    Column(
        modifier = Modifier.padding(
            top = (height * 90 / 812).dp,
            start = (width * 24 / 375).dp,
            end = (width * 24 / 375).dp
        ).fillMaxSize()
    ) {
        Text(
            "What is your Mother language? AAAAAAAAAAAAAAAAAAAAAAAAAAa",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            color = Color(0xFF080E1E),
            modifier = Modifier
                .padding(bottom = (height * 16 / 812).dp)
        )
        val ind = remember { mutableStateOf("") }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(
                (height * 12 / 812).dp,
                Alignment.CenterVertically
            )
        ) {
            itemsIndexed(languages) { index, lang ->
                Button(
                    onClick = {
                        ind.value = lang
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                        if (ind.value == lang) {
                            Color(0xFFF76400)
                        } else {
                            Color(0xFFFFF6EB)
                        }
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        lang,
                        modifier = Modifier
                            .padding(
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
        Button(
            onClick = { navController.navigate(Route.SignUp.route) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "Next",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = (height * 16 / 812).dp)
            )
        }

    }
}
