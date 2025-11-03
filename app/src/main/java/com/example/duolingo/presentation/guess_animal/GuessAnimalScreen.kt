package com.example.duolingo.presentation.guess_animal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.fonts
import com.example.duolingo.presentation.Route

@Composable
fun GuessAnimal(
    answer: MutableState<String>,
    page: MutableState<String>,
) {


    Column(
        modifier = Modifier
            .padding(25.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        Box(modifier = Modifier.clip(shape = RoundedCornerShape(20.dp))) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.racoon),
                "blabla",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }

        Text(
            stringResource(R.string.guess_text),
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
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                stringResource(R.string.btn_check),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
    }
}

@Composable
fun SuccessGuess(
    answer: MutableState<String>,
    page: MutableState<String>,
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Spacer(Modifier.weight(1f))
        Text(
            "\uD83C\uDF89",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 160.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.weight(1f))
        Text(
            stringResource(R.string.success_guess),
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.weight(0.5f))
        Button(
            onClick = {
                page.value = "Guess";
                answer.value = ""
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
                stringResource(R.string.btn_next),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
        Spacer(Modifier.weight(6f))

    }
}

@Composable
fun ErrorGuess(
    answer: MutableState<String>,
    page: MutableState<String>,
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Spacer(Modifier.weight(1f))

        Text(
            "\uD83D\uDE3F",
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 160.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.weight(1f))
        Text(
            stringResource(R.string.error_guess),
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 18.dp)
        )
        Button(
            onClick = {
                page.value = "Guess";
                answer.value = ""
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(bottom = 11.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                stringResource(R.string.btn_next),
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
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5B7BFE)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                stringResource(R.string.btn_try_again),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
        Spacer(Modifier.weight(6f))

    }

}

@Composable
fun GuessAnimalScreen(navController: NavController) {
    val answer = remember { mutableStateOf("") }
    val page = remember { mutableStateOf("Guess") }
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
                    .padding(20.dp)
                    .clickable { navController.navigate(Route.Main(id = null)) })

            Text(
                stringResource(R.string.guess_animal),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        vertical = 20.dp,
                    )
            )

        }
        when (page.value) {
            "Guess" -> GuessAnimal(answer, page)
            "Success" -> SuccessGuess(answer, page)
            "Error" -> ErrorGuess(answer, page)
        }
    }
}