package kr.pe.paran.kbank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kr.pe.paran.kbank.presentation.screen.login.LoginScreen
import kr.pe.paran.kbank.presentation.screen.splash.SplashScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navHostController)
        }
        composable(Screen.Main.route) {
            // MainScreen(navController = navHostController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navHostController)
        }
    }
}