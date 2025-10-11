package com.example.duolingo.presentation.guess_animal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.Route
import com.example.duolingo.fonts

@Composable
fun guessAnimal(
    width: Int,
    height: Int,
    answer: MutableState<String>,
    page: MutableState<String>,
) {


    Column(
        modifier = Modifier
            .padding(
                top = (height * 17 / 812).dp,
                start = (width * 24 / 375).dp,
                end = (width * 24 / 375).dp
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy((height * 17 / 812).dp)
    ) {
        Box(modifier = Modifier.clip(shape = RoundedCornerShape(20.dp))) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.racoon),
                "blabla",
                modifier = Modifier
                    .height((height * 328 / 812).dp)
                    .width((width * 328 / 375).dp),
                contentScale = ContentScale.Fit
            )
        }

        Text(
            "Write who is on image",
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            color = Color(0xFF363B44)
        )
        TextField(
            value = answer.value,
            onValueChange = { answer.value = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0x05080E1E),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp)
        )
        Button(
            onClick = {
                if (answer.value == "racoon") page.value = "Success"
                else page.value = "Error"
            },
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
                "Check",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
    }

}

@Composable
fun successGuess(
    width: Int,
    height: Int,
    answer: MutableState<String>,
    page: MutableState<String>,
) {
    Column(modifier = Modifier.padding(horizontal = (width * 24 / 375).dp)) {
        Text(
            "\uD83C\uDF89",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 160.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = (height * 75 / 812).dp)
        )
        Text(
            "Holy Molly! That is Right!",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = (height * 42 / 812).dp)
        )
        Button(
            onClick = {
                page.value = "Guess";
                answer.value = ""
            },
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
                "Next",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
    }
}

@Composable
fun errorGuess(
    width: Int,
    height: Int,
    answer: MutableState<String>,
    page: MutableState<String>,
) {
    Column(modifier = Modifier.padding(horizontal = (width * 24 / 375).dp)) {
        Text(
            "\uD83D\uDE3F",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 160.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = (height * 75 / 812).dp)
        )
        Text(
            "Eh? Wrong answer :(\n" +
                    "That is: Racoon",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = (height * 18 / 812).dp)
        )
        Button(
            onClick = {
                page.value = "Guess";
                answer.value = ""
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height((height * 56 / 812).dp)
                .padding(bottom = (height * 11 / 812).dp),
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
            )

        }
        Button(
            onClick = {
                page.value = "Guess";
                answer.value = ""
            },
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
                "Try again",
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
    }

}

@Composable
fun GuessAnimalScreen(navController: NavController) {
    val answer = remember { mutableStateOf("") }
    val page = remember { mutableStateOf("Guess") }
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp
    Column()
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    when (page.value) {
                        "Guess" -> Color(0xFF410FA3)
                        "Success" -> Color(0xFF5BA890)
                        "Error" -> Color(0xFFD6185D)

                        else -> {
                            Color.White
                        }
                    }
                )
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
                "Guess the animal",
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
        when (page.value) {
            "Guess" -> guessAnimal(width, height, answer, page)
            "Success" -> successGuess(width, height, answer, page)
            "Error" -> errorGuess(width, height, answer, page)
        }
    }
}