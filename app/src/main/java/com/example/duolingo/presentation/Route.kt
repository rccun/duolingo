package com.example.duolingo.presentation

import kotlinx.serialization.Serializable

sealed class Route() {

    @Serializable data object StartDestinationGraph : Route()
    @Serializable data object Splash: Route()
    @Serializable data object OnBoard: Route()

    @Serializable data object LanguageSelect: Route()

    @Serializable data object AuthGraph : Route()
    @Serializable data object SignUp: Route()
    @Serializable data object SignUpPassword: Route()

    @Serializable data object LogIn: Route()

    @Serializable data object MainGraph : Route()

    @Serializable data class Main(val id: String? = null): Route()


    @Serializable data object ExerciseGraph : Route()
    @Serializable data object GuessAnimal: Route()
    @Serializable data object WordPractice: Route()
    @Serializable data object Game: Route()
    @Serializable data object Audition: Route()


    @Serializable data object ProfileGraph : Route()
    @Serializable data object Profile: Route()
    @Serializable data object ResizePhoto: Route()
}
object Routes {
    const val Main = "main"
    const val Splash = "splash"
    const val Login = "login"
}
