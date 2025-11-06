package com.example.week7_assingment.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6A1B9A),
    secondary = Color(0xFFAB47BC),
    tertiary = Color(0xFFBA68C8),
    background = Color(0xFF1E1E1E),
    surface = Color(0xFF2C2C2C)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6A1B9A),
    secondary = Color(0xFFAB47BC),
    tertiary = Color(0xFFBA68C8),
    background = Color(0xFFE1BEE7),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF6A1B9A),
    onSurface = Color(0xFF1C1B1F)
)

@Composable
fun ShakeToQuoteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}