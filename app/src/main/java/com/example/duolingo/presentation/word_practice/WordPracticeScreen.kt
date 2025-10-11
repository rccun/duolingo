@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.duolingo.presentation.word_practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.Route
import com.example.duolingo.fonts


@Composable
fun WordPracticeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp
    val words = listOf<String>("Муха", "Садовник", "Гладиолус", "Собака")
    val ans = remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }
    // val ans = remember { mutableStateOf("") }
    Column() {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.word_practice),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = (height * 22 / 812).sp,
                    color = Color.White
                )
            },
            navigationIcon = {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.back2),
                    "back",
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { navController.navigate(Route.Main.route) })
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Blue
            )
        )
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
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy((height * 10 / 812).dp),
                modifier = Modifier.weight(1f)
            )
            {
                itemsIndexed(words) { ind, w ->

                    Button(
                        onClick = {
                            ans.value = w

                        },
                        enabled = true,//if () {} else {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((height * 56 / 812).dp),
                        colors = ButtonDefaults.buttonColors(
                            if (!isChecked.value) {
                                if (ans.value == w) {
                                    Color(0xFF5B7BFE)
                                } else {
                                    Color(0xFFE5E5E5)
                                }
                            } else {
                                if (ans.value == "Садовник") {
                                    if (w == "Садовник") Color(0xFF5BA890)
                                    else Color(0xFFE5E5E5)
                                } else {
                                    if (w == "Садовник") Color(0xFF5BA890)
                                    else {
                                        if (ans.value != w) Color(0xFFE5E5E5)
                                        else Color(0xFFF76400)
                                    }
                                }
                            }
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            w,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,

                            color =
                                if (!isChecked.value) {
                                    if (ans.value == w) {
                                        Color.White
                                    } else {
                                        Color(0xFF080E1E)
                                    }
                                } else {
                                    if (ans.value == "Садовник") {
                                        Color(0xFF080E1E)
                                    } else {
                                        if (ans.value == w) {
                                            Color.White
                                        } else {
                                            Color(0xFF080E1E)
                                        }
                                    }
                                }
                        )
                    }
                }
            }
            Button(
                onClick = {
                    //ans.value = ""
                    isChecked.value = !isChecked.value
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = (height * 24 / 812).dp)
                    .height((height * 56 / 812).dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text =
                        if (isChecked.value) "Next"
                        else "Check",
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = (height * 20 / 812).sp,
                    color = Color.White,
                )
            }
        }
    }
}