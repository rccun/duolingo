package com.example.duolingo.presentation.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duolingo.MyDialog
import com.example.duolingo.R
import com.example.duolingo.fonts
import com.example.duolingo.isPasswordValid
import com.example.duolingo.isValid
import com.example.duolingo.presentation.Route


@Composable
fun LogInScreen(
    navController: NavController
) {
    var showDialog = remember { mutableStateOf(false) }
    var mes = remember { mutableStateOf("") }

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
                        vertical = 20.dp,
                        horizontal = 24.dp,
                    )
                    .clickable { navController.navigate(Route.LanguageSelect) })

            Text(
                stringResource(R.string.login),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .align(Alignment.Center)
            )

        }


        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
        ) {
            val email = remember { mutableStateOf("") }
            val passw = remember { mutableStateOf("") }
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.login),
                "login",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    //.weight(1f)
                    .height(82.dp),

                contentScale = ContentScale.FillHeight

            )
            Text(
                stringResource(R.string.login_text),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 12.dp),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color(0xFF080E1E),
                textAlign = TextAlign.Center
            )

            Text(
                stringResource(R.string.email_address),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = 32.dp, bottom = 8.dp,
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
                        fontSize = 15.sp,
                        color = Color(0x50656872),
                        )
                })
            Text(
                stringResource(R.string.password),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = 24.dp, bottom = 8.dp,
                )
            )
            TextField(
                value = passw.value,
                onValueChange = { passw.value = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0x05080E1E),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(
                        "********",
                        fontFamily = fonts,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color(0x50656872),
                        )
                })
            val con = LocalContext.current
            Text(
                stringResource(R.string.forgot_passw),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFFD6185D),
                modifier = Modifier
                    .clickable {
                        Toast.makeText(
                            con,
                            "forgot passw",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .padding(top = 12.dp)
            )
            Button(
                onClick = {
                    if (email.value == "") {
                        mes.value = "Email не должен быть пустым"
                        showDialog.value = true
                    }
                    else if (passw.value == "") {
                        mes.value = "Пароль не должен быть пустым"
                        showDialog.value = true
                    }
                    else {
                        if (isValid(email.value)) {
                            if (isPasswordValid(passw.value) == "") navController.navigate(Route.Main(id = null))
                            else {
                                mes.value = isPasswordValid(passw.value)
                                showDialog.value = true
                            }
                        } else {
                            mes.value = "Введен некорректный email"
                            showDialog.value = true
                        }
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    stringResource(R.string.login),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    stringResource(R.string.not_memb),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 17.sp,
                    color = Color(0xFF656872),
                )
                Text(
                    stringResource(R.string.sign_up),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    color = Color(0xFF5B7BFE),
                    modifier = Modifier.clickable { navController.navigate(Route.SignUp) })

            }
            MyDialog(
                title = stringResource(R.string.error),
                text = mes.value,
                show = showDialog.value,
                onDismissRequest = { showDialog.value = false },
                confirmButton = {
                    TextButton(onClick = { showDialog.value = false }) {
                        Text(stringResource(R.string.ok))
                    }
                }
            )
        }
    }
}