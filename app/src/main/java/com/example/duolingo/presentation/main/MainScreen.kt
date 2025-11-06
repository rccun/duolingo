package com.example.duolingo.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.fonts
import com.example.duolingo.presentation.Route
import com.example.duolingo.presentation.components.AsyncImage
import com.example.duolingo.presentation.theme.Blue
import com.example.duolingo.presentation.theme.Green
import com.example.duolingo.presentation.theme.Orange
import com.example.duolingo.presentation.theme.Red

data class User(
    val avatar: String,
    val name: String,
    val score: Int,
)

data class Exersize(
    val avatar: String,
    val desc: String,
    val color: Color,
    val page: Route
)

@Composable
fun MainScreen(navController: NavController, id: String) {

//    val exercises = listOf(
//        Exersize(
//            "\uD83D\uDC3B\u200D❄\uFE0F",
//            stringResource(R.string.guess_animal),
//            Color(0xFF5B7BFE),
//            Route.GuessAnimal
//        ),
//        Exersize(
//            "✏\uFE0F",
//            stringResource(R.string.word_practice),
//            Color(0xFFD6185D),
//            Route.WordPractice
//        ),
//        Exersize(
//            "\uD83D\uDD0A",
//            stringResource(R.string.audition),
//            Color(0xFFF76400),
//            Route.Audition
//        ),
//        Exersize("\uD83C\uDFAE", stringResource(R.string.game), Color(0xFF5BA890), Route.Game),
//    )
    val viewModel: MainViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.loadProfile(id)
        viewModel.loadProfiles()
        viewModel.loadExercises()
    }

    when {
        state.isLoading -> Text("Загрузка...")
        state.errorMessage != null -> Text("Ошибка: ${state.errorMessage}")
        state.profileModel != null -> {
            val profile = state.profileModel

            Column() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF410FA3))
                        .padding(horizontal = 24.dp)
                )
                {
                    profile?.let { user ->
                        AsyncImage(
                            profile.avatarUrl,
                            Modifier
                                .padding(
                                    top = 20.dp,
                                    bottom = 5.dp
                                )
                                .height(54.dp)
                                .clip(CircleShape),
                            desc = "User avatar"
                        )
                        Text(
                            stringResource(R.string.hello) + " " + user.firstName,
                            fontFamily = fonts,
                            fontWeight = FontWeight.Medium,
                            fontSize = 22.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(
                                    bottom = 5.dp
                                )
                        )
                    } ?: Text("Загрузка...")


                    Text(
                        stringResource(R.string.main_desc),
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        color = Color(0xFFB6B6B6),
                        modifier = Modifier
                            .padding(
                                bottom = 11.dp
                            )
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                )
                {
                    Text(
                        stringResource(R.string.top_users),
                        modifier = Modifier.padding(
                            top = 11.dp,
                            bottom = 5.dp
                        ),
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.Black,
                    )
                    if (state.topUsers != null) {
                        val users = state.topUsers ?: emptyList()
                        LazyColumn {
                            items(users, key = { it.id }) { user ->

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(shape = RoundedCornerShape(20.dp))
                                        .background(Color(0xFFE5E5E5))
                                        .padding(15.dp)

                                )
                                {
                                    AsyncImage(
                                        user.avatarUrl,
                                        Modifier
                                            .clip(CircleShape)
                                            .height(45.dp),
                                        "User avatar"
                                    )
                                    Text(
                                        user.lastName,
                                        fontFamily = fonts,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 17.sp,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .padding(start = 24.dp)
                                            .weight(1f)
                                            .align(Alignment.CenterVertically)
                                    )
                                    Text(
                                        user.score.toString() + stringResource(R.string.points),
                                        fontFamily = fonts,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 17.sp,
                                        color = Color.Black,
                                        modifier = Modifier.align(Alignment.CenterVertically)
                                    )

                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                    Text(
                        stringResource(R.string.exer_title),
                        modifier = Modifier.padding(vertical = 10.dp),
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = Color.Black,
                    )
                    if (state.exercises != null) {
                        val exercises = state.exercises ?: emptyList()

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(17.dp),
                            horizontalArrangement = Arrangement.spacedBy(21.dp)
                        )
                        {
                            itemsIndexed(exercises) { index, exercise ->
                                val key = exercise.id
                                Column(
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(20.dp))
//                                        .background(Color(0xFFFFFFFF))
//                                        .background(Color(exercise.color or Color.Transparent.toArgb()))
                                        .background(
                                            when (index) {
                                                0 -> Orange
                                                1 -> Green
                                                2 -> Blue
                                                3 -> Red
                                                else -> Color.Transparent
                                            }
                                        )
                                        .clickable {
                                            navController.navigate(
                                                when (exercise.title) {
                                                    "Audition" -> Route.Audition
                                                    "Game" -> Route.Game
                                                    "Word practice" -> Route.WordPractice
                                                    "Guess the animal" -> Route.GuessAnimal
                                                    else -> Route.Main
                                                }
                                            )
                                        }
                                ) {
//                                    Text("\uD83D\uDC3B\u200D❄\uFE0F", /*modifier = Modifier.height(90.dp),*/ fontSize = 90.sp)
//                                    ExerciseAvatar(
//                                        exercise.imageUrl,
//                                        Modifier
//                                            .height(90.dp)
//                                            .align(Alignment.CenterHorizontally)
//                                            .padding(vertical = 10.dp)
//                                    )
                                    Text(
                                        exercise.icon,
                                        fontFamily = fonts,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 90.sp,
                                        color = Color.Black,
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                    Text(
                                        exercise.title,// + "  " + index.toString(),
                                        fontFamily = fonts,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 13.sp,
                                        color = Color.White,
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .padding(bottom = 10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}