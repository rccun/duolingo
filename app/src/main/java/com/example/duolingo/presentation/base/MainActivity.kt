package com.example.duolingo.presentation.base

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.duolingo.ThemeManager
import com.example.duolingo.presentation.Route
import com.example.duolingo.presentation.audition.AuditionScreen
import com.example.duolingo.presentation.game.GameScreen
import com.example.duolingo.presentation.guess_animal.GuessAnimalScreen
import com.example.duolingo.presentation.language_select.LanguageSelectScreen
import com.example.duolingo.presentation.login.LogInScreen
import com.example.duolingo.presentation.main.MainScreen
import com.example.duolingo.presentation.onboard.OnBoardScreen
import com.example.duolingo.presentation.profile.ProfileScreen
import com.example.duolingo.presentation.profile.ResizePhotoScreen
import com.example.duolingo.presentation.sign_up.SignUpPasswordScreen
import com.example.duolingo.presentation.sign_up.SignUpScreen
import com.example.duolingo.presentation.sign_up.SignUpViewModel
import com.example.duolingo.presentation.splash.SplashScreen
import com.example.duolingo.presentation.theme.DuolingoTheme
import com.example.duolingo.presentation.word_practice.WordPracticeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var signUpViewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            signUpViewModel = hiltViewModel()
            val navController = rememberNavController()
            val themeManager = remember { ThemeManager() }
            Log.d("TAG", themeManager.isDarkTheme.toString())

            DuolingoTheme(dynamicColor = false) {
                Scaffold(
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.MainGraph,
                        modifier = Modifier.Companion
                            .padding(innerPadding)
                    ) {
                        navigation<Route.StartDestinationGraph>(
                            startDestination = Route.Splash
                        ) {
                            composable<Route.Splash> {
                                SplashScreen(navController)
                            }
                            composable<Route.OnBoard> {
                                OnBoardScreen(navController)
                            }
                        }
                        composable<Route.LanguageSelect> {
                            LanguageSelectScreen(navController)
                        }
                        navigation<Route.AuthGraph>(
                            startDestination = Route.SignUp
                        ) {
                            composable<Route.SignUp> {
                                SignUpScreen(navController, signUpViewModel)
                            }
                            composable<Route.SignUpPassword> {
                                SignUpPasswordScreen(navController, signUpViewModel)
                            }
                            composable<Route.LogIn> {
                                LogInScreen(navController)
                            }
                        }


                        navigation<Route.MainGraph>(
                            startDestination = Route.Main(id = null)
                        ) {
                            composable<Route.Main> {
                                backStackEntry ->
                                val args = backStackEntry.toRoute<Route.Main>()
                                val userId = args.id?: "3997cd0e-5de3-48a0-b80d-0bd1ecb589ba"// "12345"
                                MainScreen(navController, userId)
                            }
                        }
                        navigation<Route.ExerciseGraph>(
                            startDestination = Route.GuessAnimal
                        ) {
                            composable<Route.GuessAnimal> {
                                GuessAnimalScreen(navController)
                            }
                            composable<Route.WordPractice> {
                                WordPracticeScreen(navController)
                            }
                            composable<Route.Game> {
                                GameScreen(navController)
                            }
                            composable<Route.Audition> {
                                AuditionScreen(navController)
                            }
                        }
                        navigation<Route.ProfileGraph>(
                            startDestination = Route.Profile
                        ) {
                            composable<Route.Profile> {
                                ProfileScreen(navController)
                            }
                            composable<Route.ResizePhoto> {
                                ResizePhotoScreen(navController)
                            }
                        }
                    }
                }
            }
        }
    }
}