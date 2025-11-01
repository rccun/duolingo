package com.example.duolingo.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.duolingo.LocalThemeManager
import com.example.duolingo.ThemeManager


data class darkScheme(
    val textColor: Color,
    val secondTextColor: Color,
    val clickableText: Color,
    val btnColor: Color,
    val btnTextColor: Color,
)
private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    background = Dark,
    secondary = PurpleGrey80,
    tertiary = Pink80
)
//private val DarkColorScheme = darkScheme(
//    textColor = White,
//    secondTextColor = White60,
//    clickableText = Blue,
//    btnColor = Blue,
//    btnTextColor = White,
//    circleColor = White30
//)
//
// private val light = darkScheme(

//    textColor = Dark,
//    secondTextColor = dark60,
//    clickableText = Blue,
//    titleColor = DarkLighter,
//    textFieldColor = GrayDark50,
    // memberTextColor = GrayDark,
    // forgotTextColor = Red

//    btnColor = Blue,
//    btnUnactiveColor = GrayLight,
//    btnTextColor = White,

//    langActiveColor = orange,
//    langUnactiveColor = YellowLight,
//    circleColor = Dark20
//)

private val LightColorScheme = lightColorScheme(
    background = White,
    primary = Blue,
//    onPrimary = White,
//    primaryContainer = GrayLight,

    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun DuolingoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val themeManager = remember { ThemeManager() }
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (themeManager.isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        themeManager.isDarkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    CompositionLocalProvider(
        LocalThemeManager provides themeManager
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}