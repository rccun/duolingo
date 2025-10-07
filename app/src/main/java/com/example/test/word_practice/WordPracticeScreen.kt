package com.example.test.word_practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.R
import com.example.test.Route
import com.example.test.fonts


@Composable
fun WordPracticeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp
    val words = listOf<String>("Муха", "Садовник", "Гладиолус", "Собака")
    val word = remember { mutableStateOf("") }
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF410FA3))
        )
        {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.back2),
                "back",
                modifier = Modifier
                    .padding(
                        top = (height * 44 / 812).dp,
                        start = (width * 24 / 375).dp,
                        end = (width * 21 / 375).dp,
                        bottom = (height * 21 / 812).dp
                    )
                    .clickable { navController.navigate(Route.Main.route) })

            Text(
                "Word practice",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = (height * 22 / 812).sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        top = (height * 44 / 812).dp, bottom = (height * 20 / 812).dp
                    )
            )

        }
        Column(
            modifier = Modifier
                .padding(horizontal = (width * 24 / 375).dp)
                .fillMaxWidth()
        ) {
            Text(
                "gardener",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = (height * 34 / 812).dp),
                fontFamily = fonts,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp
            )
            Text(
                "[ 'gɑ:dnə ]",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = (height * 2 / 812).dp, bottom = (height * 35 / 812).dp),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp
            )
            LazyColumn(verticalArrangement = Arrangement.spacedBy((height * 10 / 812).dp))
            {
                itemsIndexed(words) { ind, w ->

                    Button(
                        onClick = {
                            word.value = w

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((height * 56 / 812).dp),
                        colors = ButtonDefaults.buttonColors(
                            if (word.value == w) {
                                Color(0xFF5B7BFE)
                            } else {
                                Color(0xFFE5E5E5)
                            }
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            w,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            color = if (word.value == w) {
                                Color.White
                            } else {
                                Color(0xFF080E1E)
                            }

                        )

                    }
                }
            }
        }
    }
}