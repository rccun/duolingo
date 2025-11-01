package com.example.duolingo.presentation.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.duolingo.MyDialog
import com.example.duolingo.R
import com.example.duolingo.fonts
import com.example.duolingo.presentation.Route


@Composable
fun SignUpPasswordScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    var showDialog = remember { mutableStateOf(false) }
    var mes = remember { mutableStateOf("") }


    val state = viewModel.state.value

    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess == true) {
            navController.navigate(Route.Main(id = state.id))
        }
    }
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
                        vertical = 20.dp,
                        horizontal = 24.dp,
                    )
                    .clickable {
                        navController.navigate(Route.SignUp) }
            )

            Text(
                stringResource(R.string.sign_up),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        vertical = 20.dp,
                    )
                    .align(Alignment.Center)
            )

        }


        val clickablePart = stringResource(R.string.rules_clickable_text)


        val annotatedText = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF656872),
                    fontSize = 17.sp
                )
            ) { append(stringResource(R.string.rules_i)) }
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
                append(stringResource(R.string.rules_text))
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
                    24.dp
                )
                .fillMaxSize()
        )
        {
            val passw = remember { mutableStateOf("") }
            val conf = remember { mutableStateOf("") }
            val mes = remember { mutableStateOf("") }
            Text(
                stringResource(R.string.choose_passw),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp, top = 20.dp),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color(0xFF080E1E)
            )

            Text(
                stringResource(R.string.password),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = 24.dp, bottom = 8.dp
                )
            )
            TextField(
                value = state.password,
                onValueChange = { viewModel.onEvent(SignUpEvents.OnPasswordValueChange(it)) },
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
            Text(
                stringResource(R.string.conf_passw),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = 24.dp, bottom = 8.dp
                )
            )
            TextField(
                value = state.confPassword,
                onValueChange = { viewModel.onEvent(SignUpEvents.OnConfPasswordValueChange(it)) },
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
            val checkedState = remember { mutableStateOf(false) }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            )
            {
                Checkbox(
                    checked = state.accepted,
                    onCheckedChange = {

                        viewModel.onEvent(SignUpEvents.OnTermsClick(it))
                                      },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF5B7BFE),
                        uncheckedColor = Color(0xFF5B7BFE)
                    )

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
            Spacer(
                Modifier.weight(1f)
            )
            Button(
                onClick = {
                    viewModel.onEvent(SignUpEvents.OnSignUpClick)
                    showDialog.value = state.isSuccess == false
                    mes.value = state.errorMessage
//                    if (checkedState.value == true) {
//                        if (passw.value == conf.value) {
//                            if (isPasswordValid(passw.value) != "") {
//                                mes.value = isPasswordValid(passw.value)
//                                showDialog.value = true
//                            } else navController.navigate(Route.LogIn.route)
//                        } else {
//                            mes.value = "Пароли не совпадают"
//                            showDialog.value = true
//                        }
//                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),//top = (height * 73 / 812).dp, ),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF5B7BFE)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    stringResource(R.string.sign_up),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    stringResource(R.string.already_memb),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Normal,
                    fontSize = 17.sp,
                    color = Color(0xFF656872),
                )
                Text(
                    stringResource(R.string.login),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    color = Color(0xFF5B7BFE),
                    modifier = Modifier.clickable { navController.navigate(Route.LogIn) })
            }
            Spacer(Modifier.weight(3f))
            MyDialog(
                title = stringResource(R.string.error),
                text = mes.value,
                show = showDialog.value,
                onDismissRequest = { showDialog.value = false },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog.value = false
                    }) {
                        Text(stringResource(R.string.ok))
                    }
                }
            )
        }
    }
}