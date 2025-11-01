package com.example.duolingo.presentation.main

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.domain.model.ProfileModel
import com.example.duolingo.fonts
import com.example.duolingo.presentation.Route
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
    val viewModel: MainViewModel = hiltViewModel()
    val state = viewModel.state.value
    val profile by viewModel.profile.collectAsState()
    val imageUrl = profile!!.avatarUrl

    val avatarBitmap by viewModel.avatarBitmap.collectAsState()

    LaunchedEffect(imageUrl) {
        withContext(Dispatchers.IO) {
            viewModel.loadProfile(id)
        }
    }
    LaunchedEffect(state.profileModel?.avatarUrl) {
        state.profileModel?.avatarUrl?.let { avatarUrl ->
            viewModel.loadAvatar(avatarUrl)
        }
    }

//    if (bitmap != null) {
//        Image(
//            bitmap = bitmap!!,
//            contentDescription = "Avatar",
//            modifier = Modifier
//                .size(64.dp)
//                .clip(CircleShape)
//        )
//    } else {
//        CircularProgressIndicator()
//    }

    val users = listOf(
        User("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8", stringResource(R.string.vincent), 12),
        User("\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDD2C", stringResource(R.string.mendeleev), 10),
        User("\uD83E\uDDDB\uD83C\uDFFB\u200D♂\uFE0F", stringResource(R.string.tepes), 8)
    )
    val exersizes = listOf(
        Exersize(
            "\uD83D\uDC3B\u200D❄\uFE0F",
            stringResource(R.string.guess_animal),
            Color(0xFF5B7BFE),
            Route.GuessAnimal
        ),
        Exersize(
            "✏\uFE0F",
            stringResource(R.string.word_practice),
            Color(0xFFD6185D),
            Route.WordPractice
        ),
        Exersize(
            "\uD83D\uDD0A",
            stringResource(R.string.audition),
            Color(0xFFF76400),
            Route.Audition
        ),
        Exersize("\uD83C\uDFAE", stringResource(R.string.game), Color(0xFF5BA890), Route.Game),
    )
    Column() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF410FA3))
                .padding(horizontal = 24.dp)
        )
        {
            Image(
                bitmap = avatarBitmap!!,
                "avatar",
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        bottom = 5.dp
                    )
                    .height(54.dp),
                contentScale = ContentScale.FillHeight
            )
            Text(
                stringResource(R.string.hello) + " " + state.profileModel!!.firstName,
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        bottom = 5.dp
                    )
            )
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
            repeat(users.size) { ind ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(Color(0xFFE5E5E5))
                        .padding(15.dp)

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
                            .padding(start = 24.dp)
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        users[ind].score.toString() + stringResource(R.string.points),
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            Text(
                stringResource(R.string.exer_title),
                modifier = Modifier.padding(vertical = 10.dp),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.Black,
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(17.dp),
                horizontalArrangement = Arrangement.spacedBy(21.dp)
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