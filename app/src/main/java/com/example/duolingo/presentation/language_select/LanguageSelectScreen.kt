package com.example.duolingo.presentation.language_select


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.Route
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.duolingo.R
import com.example.duolingo.fonts


@Composable
fun LanguageSelectScreen(
    navController: NavController
) {


//    val configuration = LocalConfiguration.current
//    val width = configuration.screenWidthDp
//    val height = configuration.screenHeightDp


    val languages = LocalContext.current.resources.getStringArray(R.array.langs).toList()

    Column() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF410FA3))) {
            Text(

                stringResource(R.string.lang_select_title),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        bottom = 20.dp
                    )
                    .align(Alignment.Center)
            )
        }
        ConstraintLayout(
            modifier = Modifier
                .padding(
                    horizontal = 24.dp
                )
                .fillMaxSize()
        ) {
            val (text, lazy, btn) = createRefs()
            Text(
                stringResource(R.string.lang_select_text),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color(0xFF080E1E),
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .padding(bottom = 16.dp)

            )
            val ind = remember { mutableStateOf(languages[0]) }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(
                    12.dp,
                    Alignment.CenterVertically
                ),
                modifier = Modifier.constrainAs(lazy) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                }
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
                                    vertical = 20.dp
                                )
                                .fillMaxWidth(),
                            fontFamily = fonts,
                            fontWeight = FontWeight.Medium,
                            fontSize = 22.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Start
                        )
                    }

                }
            }
            Button(
                onClick = { navController.navigate(Route.SignUp.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(btn) {
                        bottom.linkTo(parent.bottom, margin = 25.dp)
                        start.linkTo(parent.start)
                    },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    stringResource(R.string.btn_choose),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

        }
    }
}