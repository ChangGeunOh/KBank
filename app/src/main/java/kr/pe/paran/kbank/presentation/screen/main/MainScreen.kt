package kr.pe.paran.kbank.presentation.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.pe.paran.kbank.R
import kr.pe.paran.kbank.navigation.BottomNavigationItem
import kr.pe.paran.kbank.navigation.Screen
import kr.pe.paran.kbank.presentation.screen.alarm.AlarmScreen
import kr.pe.paran.kbank.presentation.screen.home.HomeScreen
import kr.pe.paran.kbank.presentation.screen.main.component.BottomNavigation
import kr.pe.paran.kbank.presentation.screen.product.ProductScreen
import kr.pe.paran.kbank.presentation.screen.total.TotalScreen

@Composable
fun MainScreen(
    navController: NavController,
) {

    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navHostController,
                navigationItems = listOf(
                    BottomNavigationItem(
                        route = Screen.Home.route,
                        icon = R.drawable.ic_bottom_home,
                        contentDescription = "홈"
                    ),
                    BottomNavigationItem(
                        route = Screen.Product.route,
                        icon = R.drawable.ic_bottom_product,
                        contentDescription = "상품"
                    ),
                    BottomNavigationItem(
                        route = Screen.Alarm.route,
                        icon = R.drawable.ic_bottom_alarm,
                        contentDescription = "알림"
                    ),
                    BottomNavigationItem(
                        route = Screen.Total.route,
                        icon = R.drawable.ic_bottom_total,
                        contentDescription = "전체"
                    ),
                )
            )
        }
    ) {
        NavHost(
            modifier = Modifier
                .padding(it),
            navController = navHostController,
            startDestination = Screen.Home.route,
        ) {
            composable(
                route = Screen.Home.route,
            ) {
                HomeScreen(navController = navHostController)
            }
            composable(
                route = Screen.Product.route,
            ) {
                ProductScreen(navController = navHostController)
            }
            composable(
                route = Screen.Alarm.route
            ) {
                AlarmScreen(navController = navHostController)
            }
            composable(
                route = Screen.Total.route
            ) {
                TotalScreen(navController = navHostController)
            }
        }
    }
}


