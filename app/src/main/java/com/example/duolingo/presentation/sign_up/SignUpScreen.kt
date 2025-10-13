package com.example.duolingo.presentation.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import com.example.duolingo.MyDialog
import com.example.duolingo.R
import com.example.duolingo.Route
import com.example.duolingo.fonts
import com.example.duolingo.isValid

@Composable
fun SignUpScreen(
    navController: NavController
) {
    var showDialog = remember { mutableStateOf(false) }

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF410FA3))
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.icon_back),
                "back",
                modifier = Modifier
                    .padding(
                        top = (height * 61 / 812).dp,
                        start = (width * 24 / 375).dp,
                        bottom = (height * 21 / 812).dp
                    )
                    .clickable { navController.navigate(Route.LogIn.route) })

            Text(
                stringResource(R.string.sign_up),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = (height * 17 / 812).sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        top = (height * 60 / 812).dp, bottom = (height * 20 / 812).dp
                    )
                    .align(Alignment.Center)
            )

        }


        Column(
            modifier = Modifier
                .padding(
                    top = (height * 40 / 812).dp,
                    start = (width * 24 / 375).dp,
                    end = (width * 24 / 375).dp
                )
                .fillMaxSize()
        ) {
            val first_name = remember { mutableStateOf("") }
            val last_name = remember { mutableStateOf("") }
            val email = remember { mutableStateOf("") }
            Text(
                stringResource(R.string.create_acc),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = (height * 8 / 812).dp),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color(0xFF080E1E)
            )

            Text(
                stringResource(R.string.first_name),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = (height * 15 / 812).sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = (height * 24 / 812).dp, bottom = (height * 8 / 812).dp
                )
            )
            TextField(
                value = first_name.value,
                onValueChange = { first_name.value = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0x05080E1E),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(
                        stringResource(R.string.your_fn),
                        fontFamily = fonts,
                        fontWeight = FontWeight.Normal,
                        fontSize = (height * 15 / 812).sp,
                        color = Color(0x50656872),


                        )
                })
            Text(
                stringResource(R.string.last_name),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = (height * 15 / 812).sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = (height * 24 / 812).dp, bottom = (height * 8 / 812).dp
                )
            )
            TextField(
                value = last_name.value,
                onValueChange = { last_name.value = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0x05080E1E),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(
                        stringResource(R.string.your_ln),
                        fontFamily = fonts,
                        fontWeight = FontWeight.Normal,
                        fontSize = (height * 15 / 812).sp,
                        color = Color(0x50656872),


                        )
                })
            Text(
                stringResource(R.string.email),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = (height * 15 / 812).sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = (height * 24 / 812).dp, bottom = (height * 8 / 812).dp
                )
            )
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0x05080E1E),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(
                        stringResource(R.string.email),
                        fontFamily = fonts,
                        fontWeight = FontWeight.Normal,
                        fontSize = (height * 15 / 812).sp,
                        color = Color(0x50656872),
                    )
                }
            )
            Button(
                onClick = {
                    if (isValid(email.value)) navController.navigate(Route.SignUpPassword.route)
                    else showDialog.value = true
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = (height * 34 / 812).dp, bottom = (height * 24 / 812).dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    stringResource(R.string.btn_continue),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = (height * 16 / 812).dp)
                )
            }
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    stringResource(R.string.already_memb),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = (height * 17 / 812).sp,
                    color = Color(0xFF656872),
                )
                Text(
                    stringResource(R.string.login),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = (height * 17 / 812).sp,
                    color = Color(0xFF5B7BFE),
                    modifier = Modifier.clickable { navController.navigate(Route.LogIn.route) })

            }
            MyDialog(
                title = stringResource(R.string.error),
                text = stringResource(R.string.uncorrect_email),
                show = showDialog.value,
                onDismissRequest = { showDialog.value = false },
                confirmButton = {
                    TextButton(onClick = { showDialog.value = false
                    email.value = ""}) {
                        Text(stringResource(R.string.ok))
                    }
                }
            )
        }
    }
}