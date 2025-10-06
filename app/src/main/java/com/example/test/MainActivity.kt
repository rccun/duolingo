package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.audition.AuditionScreen
import com.example.test.game.GameScreen
import com.example.test.guess_animal.GuessAnimalScreen
import com.example.test.language_select.LanguageSelectScreen
import com.example.test.login.LogInScreen
import com.example.test.main.MainScreen
import com.example.test.onboard.OnBoard2Screen
import com.example.test.onboard.OnBoard3Screen
import com.example.test.onboard.OnBoardScreen
import com.example.test.profile.ProfileScreen
import com.example.test.sign_up.SignUpPasswordScreen
import com.example.test.sign_up.SignUpScreen
import com.example.test.splash.SplashScreen
import com.example.test.ui.theme.TestTheme
import com.example.test.word_practice.WordPracticeScreen
import com.example.test.profile.ResizePhotoScreen


sealed class Route(val route: String) {

    data object Splash: Route("Splash")
    data object OnBoard: Route("OnBoard")
    data object OnBoard2: Route("OnBoard2")
    data object OnBoard3: Route("OnBoard3")
    data object LanguageSelect: Route("LanguageSelect")
    data object SignUp: Route("SignUp")
    data object SignUpPassword: Route("SignUpPassword")
    data object LogIn: Route("LogIn")
    data object Main: Route("Main")
    data object GuessAnimal: Route("GuessAnimal")
    data object WordPractice: Route("WordPractice")
    data object Game: Route("Game")
    data object Audition: Route("Audition")
    data object Profile: Route("Profile")
    data object ResizePhoto: Route("ResizePhoto")

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            TestTheme {
                NavHost(
                    navController = navController,
                    startDestination = Route.Profile.route
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
                    composable(Route.SignUpPassword.route) {
                        SignUpPasswordScreen(navController)
                    }
                    composable(Route.LogIn.route) {
                        LogInScreen(navController)
                    }
                    composable(Route.Main.route) {
                        MainScreen(navController)
                    }
                    composable(Route.GuessAnimal.route) {
                        GuessAnimalScreen(navController)
                    }
                    composable(Route.WordPractice.route) {
                        WordPracticeScreen(navController)
                    }
                    composable(Route.Game.route) {
                        GameScreen(navController)
                    }
                    composable(Route.Audition.route) {
                        AuditionScreen(navController)
                    }
                    composable(Route.Profile.route) {
                        ProfileScreen(navController)
                    }
                    composable(Route.ResizePhoto.route) {
                        ResizePhotoScreen(navController)
                    }
                }
            }
        }
    }
}