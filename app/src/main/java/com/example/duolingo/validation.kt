package com.example.duolingo

import android.util.Patterns
import androidx.annotation.DrawableRes
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.duolingo.presentation.onboard.OnBoardScreen

val fonts = FontFamily(
    Font(R.font.fredoka_m, FontWeight.Medium), Font(R.font.fredoka_r, FontWeight.Normal)
)

fun isPasswordValid(value: String): String {
    val len = value.length > 7
    var num = false
    val nums = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
    for (i in nums) {
        if (value.contains(i)) {
            num = true
            break
        }
    }
    val low = value.lowercase() == value
    val up = value.uppercase() == value
    var isSpec = false
    val spec = listOf("@", "№", "$", "#", "&", "%")
    for (i in spec) if (value.contains(i)) {
        isSpec = true
        break
    }
    if (!len) return "Пароль должен содержать минимум 8 символов"
    if (!num) return "Пароль должен содержать цифры"
    if (low) return "Пароль должен содержать заглавные буквы"
    if (up) return "Пароль должен содержать маленькие буквы"
    if (!isSpec) return "Пароль должен содержать специальные символы (@#$&%№)"
    else return ""
}
fun isValid(value: String): Boolean {

    try {

        return Patterns.EMAIL_ADDRESS.matcher(value).matches() && value == value.lowercase()
//        val name = value.substring(0, value.indexOf("@"))
//        val domen = value.substring(value.indexOf("@") + 1, value.indexOf("."))
//        val flag = value.indexOf("@") < value.indexOf(".")
//        val flag2 = name.lowercase() == name
//        val flag3 = domen.lowercase() == domen
//        if (!value.contains("@") or !value.contains(".") or !flag or !flag2 or !flag3)
//            return false
//        else return true
    } catch (ex: Exception){ return false}
}
@Composable
fun MyDialog(
    title: String,
    text: String,
    show: Boolean,
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text(title) },
            text = { Text(text) },
            confirmButton = { confirmButton() }
        )
    }
}

