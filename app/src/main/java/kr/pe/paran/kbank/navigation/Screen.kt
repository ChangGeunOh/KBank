package kr.pe.paran.kbank.navigation

sealed class Screen(val route: String) {
    data object Test : Screen("test_screen")
    data object Splash : Screen("splash_screen")
    data object Home : Screen("home_screen")
    data object Main : Screen("main_screen")
    data object Login : Screen("login_screen")
    data object Product : Screen("product_screen")
    data object Alarm : Screen("alarm_screen")
    data object Total : Screen("total_screen")
}
