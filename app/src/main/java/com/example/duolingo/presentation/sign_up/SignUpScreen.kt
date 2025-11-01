package com.example.duolingo.presentation.sign_up

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.duolingo.R
import com.example.duolingo.fonts
import com.example.duolingo.presentation.Route
import com.example.duolingo.presentation.components.MyAlertDialog
import com.example.duolingo.presentation.utils.ObserveAction

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
//    LaunchedEffect(state.isEmailValid) {
//        if (state.isEmailValid == true) {
//            navController.navigate(Route.SignUpPassword)
//        }
//    }

    val showDialog = remember { mutableStateOf("") }
    val titleDialog = remember { mutableStateOf("Error") }
    val messageDialogText = remember { mutableStateOf("") }

    ObserveAction(viewModel.channel) {
        when (it) {
            SignUpAction.OnSuccessSignUp -> navController.navigate(Route.SignUpPassword)
            is SignUpAction.OnError -> {
                showDialog.value = it.message
            }
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
                    .clickable { navController.navigate(Route.SignUp) })

            Text(
                stringResource(R.string.sign_up),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(
                        vertical = 20.dp
                    )
                    .align(Alignment.Center)
            )

        }

        Column(
            modifier = Modifier
                .padding(
                    horizontal = 24.dp
                )
                .fillMaxSize()
        ) {
            Text(
                stringResource(R.string.create_acc),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp, top = 40.dp),
                fontFamily = fonts,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
                color = Color(0xFF080E1E)
            )

            Text(
                stringResource(R.string.first_name),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = 24.dp, bottom = 8.dp
                )
            )
            TextField(
                value = state.firstName,
                onValueChange = { viewModel.onEvent(SignUpEvents.OnFirstNameValueChange(it)) },
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
                        fontSize = 15.sp,
                        color = Color(0x50656872),
                        )
                })
            Text(
                stringResource(R.string.last_name),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = 24.dp, bottom = 8.dp
                )
            )
            TextField(
                value = state.lastName,
                onValueChange = { viewModel.onEvent(SignUpEvents.OnLastNameValueChange(it)) },
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
                        fontSize = 15.sp,
                        color = Color(0x50656872),


                        )
                })
            Text(
                stringResource(R.string.email),
                fontFamily = fonts,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color(0xFF363B44),
                modifier = Modifier.padding(
                    top = 24.dp, bottom = 8.dp
                )
            )
            TextField(
                value = state.email,
                onValueChange = { viewModel.onEvent(SignUpEvents.OnEmailValueChange(it)) },
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
                }
            )
            Button(
                onClick = {
                    viewModel.onEvent(SignUpEvents.OnNextClick)

                    Log.d("TAG15", state.errorMessage)
                    messageDialogText.value = state.errorMessage
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
                    stringResource(R.string.btn_continue),
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
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
            MyAlertDialog(
                title = titleDialog.value,
                text = showDialog.value,

//                title = stringResource(R.string.error),
//                text = stringResource(R.string.uncorrect_email),

                show = showDialog.value.isNotBlank(),
                onDismissRequest = { showDialog.value = "" },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog.value = ""
                        viewModel.onEvent(SignUpEvents.OnEmailValueChange(""))
                    }) {
                        Text(stringResource(R.string.ok))
                    }
                }
            )
        }
    }
}