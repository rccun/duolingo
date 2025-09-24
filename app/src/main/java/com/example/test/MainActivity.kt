package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.language_select.LanguageSelectScreen
import com.example.test.onboard.OnBoard2Screen
import com.example.test.onboard.OnBoard3Screen
import com.example.test.onboard.OnBoardScreen
import com.example.test.sign_up.SignUpScreen
import com.example.test.splash.SplashScreen
import com.example.test.ui.theme.TestTheme


sealed class Route(val route: String) {

    data object Splash: Route("Splash")
    data object OnBoard: Route("OnBoard")
    data object OnBoard2: Route("OnBoard2")
    data object OnBoard3: Route("OnBoard3")
    data object LanguageSelect: Route("LanguageSelect")
    data object SignUp: Route("SignUp")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val f_sb = FontFamily(Font(R.font.fredoka_sb))

            val navController = rememberNavController()
            TestTheme {
                NavHost(
                    navController = navController,
                    startDestination = Route.Splash.route
                ) {
                    composable(Route.Splash.route) {
                        SplashScreen(navController)
                    }
                    composable(Route.OnBoard.route) {
                        OnBoardScreen(navController)
                    }
                    composable(Route.OnBoard2.route) {
                        OnBoard2Screen(navController)
                    }
                    composable(Route.OnBoard3.route) {
                        OnBoard3Screen(navController)
                    }
                    composable(Route.LanguageSelect.route) {
                        LanguageSelectScreen(navController)
                    }
                    composable(Route.SignUp.route) {
                        SignUpScreen(navController)
                    }
                }
            }
        }
    }
}