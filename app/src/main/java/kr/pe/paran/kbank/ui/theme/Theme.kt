package kr.pe.paran.kbank.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color(0xFF00F8F8),
)

private val lightColorScheme = lightColorScheme(
    primary = Color.White,                  // Status bar Background color
    onPrimary = Color.Red,                  // Text color
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.White,
    onBackground = Color(0xFF141414),

    scrim = Color.Black,                    // Modal Background color
    surfaceTint = Color.White,          // Modal Container Background color

    primaryContainer = Color(0xFFF1F6FB),

    onPrimaryContainer = Color(0xFFF1F6FB),
    inversePrimary = Color.Red,
    onSecondary = Color(0xFFF1F6FB),

    secondaryContainer = Color(0xFFF1F6FB),
    onSecondaryContainer = Color(0xff17008C),

    onTertiary = Color(0xFFF1F6FB),
    tertiaryContainer = Color(0xFFF1F6FB),
    onTertiaryContainer = Color(0xFFF1F6FB),
    surface = Color.White,

    onSurface = Color.Red,
    surfaceVariant = Color.Red,
    onSurfaceVariant = Color.Red,

    inverseSurface = Color.Red,
    inverseOnSurface = Color.Red,

    error = Color.Red,
    onError = Color.Red,
    errorContainer = Color.Red,
    onErrorContainer = Color.Red,
    outline = Color.Red,
    outlineVariant = Color.Red,
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
fun KBankTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) darkColorScheme else lightColorScheme
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
//    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
//    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}