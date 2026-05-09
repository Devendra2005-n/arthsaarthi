package com.arthsaarthi.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// ArthSaarthi Brand Colors
val Navy = Color(0xFF0A2342)
val Gold = Color(0xFFD4AF37)
val Teal = Color(0xFF007B8A)
val LightBlue = Color(0xFFE8F4FD)
val DarkGray = Color(0xFF1A1A2E)
val MediumGray = Color(0xFF5A6A7A)
val LightGray = Color(0xFFF0F4F8)
val SuccessGreen = Color(0xFF1B7A3E)
val ErrorRed = Color(0xFFB22222)
val WarningOrange = Color(0xFFC45E0A)
val White = Color(0xFFFFFFFF)

private val LightColors = lightColorScheme(
    primary = Navy,
    onPrimary = White,
    primaryContainer = LightBlue,
    secondary = Teal,
    onSecondary = White,
    secondaryContainer = Color(0xFFE0F7FA),
    tertiary = Gold,
    background = LightGray,
    surface = White,
    onBackground = DarkGray,
    onSurface = DarkGray,
    error = ErrorRed
)

@Composable
fun ArthSaarthiTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}
