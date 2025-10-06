package com.example.test.sign_up

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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.R
import com.example.test.Route

import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import com.example.test.MyDialog
import com.example.test.fonts
import com.example.test.isPasswordValid


@Composable
fun SignUpPasswordScreen(
    navController: NavController
) {
    var showDialog = remember { mutableStateOf(false) }
    var mes = remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF410FA3))
        )
        {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.icon_back),
                "back",
                modifier = Modifier
                    .padding(
                        top = (height * 61 / 812).dp,
                        start = (width * 24 / 375).dp,
                        bottom = (height * 21 / 812).dp
                    )
                    .clickable { navController.navigate(Route.LanguageSelect.route) })

            Text(
                "Sign up",
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


        val clickablePart = "have made myself acquainted with the Rules"


        val annotatedText = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF656872),
                    fontSize = 17.sp
                )
            ) { append("I ") }
            withStyle(
                SpanStyle(
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF5B7BFE),
                    fontSize = 17.sp
                )
            ) {
                append(clickablePart)
            }
            withStyle(
                SpanStyle(
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF656872),
                    fontSize = 17.sp
                )
            ) {
                append(" and accept all its provisions")
            }
            addStringAnnotation(
                tag = "URL",
                annotation = "https://github.com", // URL или другая информация для обработки клика
                start = length, // Начало кликабельного текста
                end = length + clickablePart.length // Конец кликабельного текста
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
        )
        {
            val passw = remember { mutableStateOf("") }
            val conf = remember { mutableStateOf("") }
            val mes = remember { mutableStateOf("") }
            Text(
                "Choose a Passsword",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = (height * 8 / 812).dp),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color(0xFF080E1E)
            )

            Text(
                "Password",
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = (height * 15 / 812).sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = (height * 24 / 812).dp, bottom = (height * 8 / 812).dp
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
                        fontSize = (height * 15 / 812).sp,
                        color = Color(0x50656872),


                        )
                })
            Text(
                "Confirm password",
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = (height * 15 / 812).sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = (height * 24 / 812).dp, bottom = (height * 8 / 812).dp
                )
            )
            TextField(
                value = conf.value,
                onValueChange = { conf.value = it },
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
                        fontSize = (height * 15 / 812).sp,
                        color = Color(0x50656872),


                        )
                })
            val checkedState = remember { mutableStateOf(false) }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = (height * 25 / 812).dp)
            )
            {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFF5B7BFE), uncheckedColor = Color(0xFF5B7BFE))

                )
                ClickableText(
                    text = annotatedText,
                    onClick = { offset ->
                        annotatedText.getStringAnnotations(
                            tag = "URL",
                            start = offset,
                            end = offset
                        )
                            .firstOrNull()?.let { annotation ->
                                println("Клик по ссылке: ${annotation.item}")
                            }
                    }
                )
            }

            Button(
                onClick = {
                    if (checkedState.value == true) {
                        if (passw.value == conf.value) {
                            if (isPasswordValid(passw.value) != "") {
                                mes.value = isPasswordValid(passw.value)
                                showDialog.value = true
                            } else navController.navigate(Route.LogIn.route)
                        } else {
                            mes.value = "Пароли не совпадают"
                            showDialog.value = true
                        }
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = (height * 73 / 812).dp, bottom = (height * 24 / 812).dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Signup",
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = (height * 16 / 812).dp)
                )
            }
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Already you member? ",
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = (height * 17 / 812).sp,
                    color = Color(0xFF656872),
                )
                Text(
                    "Login",
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = (height * 17 / 812).sp,
                    color = Color(0xFF5B7BFE),
                    modifier = Modifier.clickable { navController.navigate(Route.LogIn.route)})
            }
            MyDialog(
                title = "Ошибка",
                text = mes.value,
                show = showDialog.value,
                onDismissRequest = { showDialog.value = false },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog.value = false
                    }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}