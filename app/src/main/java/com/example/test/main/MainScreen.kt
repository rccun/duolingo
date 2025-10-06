package com.example.test.main

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.R
import com.example.test.Route
import com.example.test.fonts

data class User(
    val avatar: String,
    val name: String,
    val score: Int,
)

data class Exersize(
    val avatar: String,
    val desc: String,
    val color: Color,
    val page: String
)

@Composable
fun MainScreen(navController: NavController) {

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp
    val users = listOf<User>(
        User("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8", "Vincent van Gogh", 12),
        User("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDD2C", "Dmitri Ivanovich Mendeleev", 10),
        User("\uD83E\uDDDB\uD83C\uDFFB\u200D♂\uFE0F", "Vlad Tepes", 8)
    )
    val exersizes = listOf<Exersize>(
        Exersize("\uD83D\uDC3B\u200D❄\uFE0F", "Guess the animal", Color(0xFF5B7BFE), "GuessAnimal"),
        Exersize("✏\uFE0F", "Word practice", Color(0xFFD6185D), "WordPractice"),
        Exersize("\uD83D\uDD0A", "Audition", Color(0xFFF76400), "Audition"),
        Exersize("\uD83C\uDFAE", "Game", Color(0xFF5BA890), "Game"),
    )
    Column() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF410FA3))
                .padding(horizontal = (width * 24 / 375).dp)
        )
        {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.placeholder),
                "avatar",
                modifier = Modifier
                    .padding(
                        top = (height * 50 / 812).dp,
                        bottom = (height * 5 / 812).dp
                    )
                    .height((height * 54 / 812).dp)
                    .width((width * 54 / 375).dp)
            )
            Text(
                "Hello, Emil",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = (height * 22 / 812).sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        bottom = (height * 5 / 812).dp
                    )
            )
            Text(
                "Are you ready for learning today?",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = (height * 17 / 812).sp,
                color = Color(0xFFB6B6B6),
                modifier = Modifier
                    .padding(
                        bottom = (height * 11 / 812).dp
                    )
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = (width * 24 / 375).dp)
        )
        {
            Text(
                "Top users",
                modifier = Modifier.padding(
                    top = (height * 11 / 812).dp,
                    bottom = (height * 5 / 812).dp
                ),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.Black,
            )
            repeat(users.size) { ind ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(Color(0xFFE5E5E5))
                        .padding(
                            horizontal = (width * 13 / 375).dp,
                            vertical = (height * 15 / 812).dp
                        )

                )
                {
                    Text(
                        users[ind].avatar,
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 36.sp,
                        color = Color.Black
                    )
                    Text(
                        users[ind].name, fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = (width * 24 / 375).dp)
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        users[ind].score.toString() + " points", fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }
                Spacer(modifier = Modifier.height((height * 10 / 812).dp))
            }
            Text(
                "Avaliable exersizes",
                modifier = Modifier.padding(
                    top = (height * 11 / 812).dp,
                    bottom = (height * 9 / 812).dp
                ),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.Black,
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy((height * 17 / 812).dp),
                horizontalArrangement = Arrangement.spacedBy((width * 21 / 375).dp)
            ) {
                items(exersizes) { exersize ->
                    Column(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(exersize.color)
                            .clickable {
                                navController.navigate(
                                    exersize.page
                                )
                            }
                    ) {
                        Text(
                            exersize.avatar,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Normal,
                            fontSize = 90.sp,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Text(
                            exersize.desc,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Normal,
                            fontSize = 13.sp,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}