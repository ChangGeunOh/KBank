package kr.pe.paran.kbank.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Main: Screen("main_screen")
}
