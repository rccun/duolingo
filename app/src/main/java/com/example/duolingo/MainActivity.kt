package com.example.duolingo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.duolingo.presentation.audition.AuditionScreen
import com.example.duolingo.presentation.game.GameScreen
import com.example.duolingo.presentation.guess_animal.GuessAnimalScreen
import com.example.duolingo.presentation.language_select.LanguageSelectScreen
import com.example.duolingo.presentation.login.LogInScreen
import com.example.duolingo.presentation.main.MainScreen
import com.example.duolingo.presentation.onboard.OnBoard2Screen
import com.example.duolingo.presentation.onboard.OnBoard3Screen
import com.example.duolingo.presentation.onboard.OnBoardScreen
import com.example.duolingo.presentation.profile.ProfileScreen
import com.example.duolingo.presentation.profile.ResizePhotoScreen
import com.example.duolingo.presentation.sign_up.SignUpPasswordScreen
import com.example.duolingo.presentation.sign_up.SignUpScreen
import com.example.duolingo.presentation.splash.SplashScreen
import com.example.duolingo.presentation.theme.DuolingoTheme
import com.example.duolingo.presentation.word_practice.WordPracticeScreen
import dagger.hilt.android.AndroidEntryPoint


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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            DuolingoTheme (dynamicColor = false) {
                Scaffold(

                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.Splash.route,
                        modifier = Modifier
                            .padding(innerPadding)
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
}