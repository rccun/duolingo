package com.example.test.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.navigation.NavController
import com.example.test.Route

@Composable
fun OnBoardScreen(
    navController: NavController
) {

    Column {
        Image()

        Row() {}
        Text()
        Text()
        Button() {}
        Text("sdjhkjsdhj", modifier = Modifier.clickable{navController.navigate(Route.OnBoard2.route)})

    }

}