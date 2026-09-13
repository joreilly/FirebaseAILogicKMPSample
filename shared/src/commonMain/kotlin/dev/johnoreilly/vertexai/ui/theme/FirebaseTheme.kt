package dev.johnoreilly.vertexai.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Firebase AI Logic inspired colors
internal val FirebaseBlue = Color(0xFF1A73E8)
internal val FirebaseLightBlue = Color(0xFF4285F4)
internal val FirebaseAmber = Color(0xFFF57C00)
internal val FirebaseRed = Color(0xFFEA4335)
internal val FirebaseGreen = Color(0xFF34A853)
internal val FirebaseYellow = Color(0xFFFBBC04)

// Light theme background colors
internal val LightBackground = Color(0xFFF8F9FA)
internal val LightSurface = Color(0xFFFFFFFF)
internal val LightSurfaceVariant = Color(0xFFE1E3E1)

// Dark theme background colors
internal val DarkBackground = Color(0xFF1F1F1F)
internal val DarkSurface = Color(0xFF121212)
internal val DarkSurfaceVariant = Color(0xFF2D2D2D)

// Text colors
internal val LightOnBackground = Color(0xFF1F1F1F)
internal val DarkOnBackground = Color(0xFFF8F9FA)

// Firebase AI Logic inspired light theme
internal val FirebaseAILogicLightColors = lightColorScheme(
    primary = FirebaseBlue,
    onPrimary = Color.White,
    primaryContainer = FirebaseLightBlue.copy(alpha = 0.15f),
    onPrimaryContainer = FirebaseBlue,
    secondary = FirebaseAmber,
    onSecondary = Color.White,
    secondaryContainer = FirebaseAmber.copy(alpha = 0.15f),
    onSecondaryContainer = FirebaseAmber,
    tertiary = FirebaseGreen,
    onTertiary = Color.White,
    tertiaryContainer = FirebaseGreen.copy(alpha = 0.15f),
    onTertiaryContainer = FirebaseGreen,
    error = FirebaseRed,
    onError = Color.White,
    errorContainer = FirebaseRed.copy(alpha = 0.15f),
    onErrorContainer = FirebaseRed,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnBackground,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnBackground.copy(alpha = 0.7f)
)

// Firebase AI Logic inspired dark theme
internal val FirebaseAILogicDarkColors = darkColorScheme(
    primary = FirebaseLightBlue,
    onPrimary = Color.White,
    primaryContainer = FirebaseBlue.copy(alpha = 0.25f),
    onPrimaryContainer = Color.White,
    secondary = FirebaseAmber,
    onSecondary = Color.Black,
    secondaryContainer = FirebaseAmber.copy(alpha = 0.25f),
    onSecondaryContainer = FirebaseAmber,
    tertiary = FirebaseGreen,
    onTertiary = Color.Black,
    tertiaryContainer = FirebaseGreen.copy(alpha = 0.25f),
    onTertiaryContainer = FirebaseGreen,
    error = FirebaseRed,
    onError = Color.White,
    errorContainer = FirebaseRed.copy(alpha = 0.25f),
    onErrorContainer = FirebaseRed,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnBackground,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnBackground.copy(alpha = 0.7f)
)