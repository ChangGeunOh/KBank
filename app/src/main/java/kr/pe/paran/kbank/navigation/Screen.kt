package kr.pe.paran.kbank.navigation

sealed class Screen(val route: String) {
    data object Test: Screen("test_screen")
    data object Splash: Screen("splash_screen")
    data object Main: Screen("main_screen")
    data object Login: Screen("login_screen")
}
