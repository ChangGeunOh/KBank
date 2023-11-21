package kr.pe.paran.kbank.presentation.screen.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kr.pe.paran.kbank.navigation.BottomNavigationItem
import kr.pe.paran.kbank.presentation.component.NoRippleInteractionSource
import kr.pe.paran.kbank.ui.theme.BottomNavigationTextColor
import kr.pe.paran.kbank.ui.theme.MainBackgroundColor
import kr.pe.paran.kbank.ui.theme.SelectedBottomNavigationIconColor
import kr.pe.paran.kbank.ui.theme.UnselectedBottomNavigationIconColor

@Composable
fun BottomNavigation(
    navigationItems: List<BottomNavigationItem> = listOf(),
    navController: NavHostController,
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier
            .background(MainBackgroundColor)
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            )
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        containerColor = Color.White,
        contentColor = Color.Blue,

        ) {
        navigationItems.forEachIndexed { _, bottomNavItem ->
            NavigationBarItem(
                selected = bottomNavItem.route == currentDestination?.route,
                onClick = {
                    navController.navigate(bottomNavItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = SelectedBottomNavigationIconColor,
                    unselectedIconColor = UnselectedBottomNavigationIconColor,
                    selectedTextColor = SelectedBottomNavigationIconColor,
                    unselectedTextColor = BottomNavigationTextColor,
                    indicatorColor = Color.White,
                ),
                interactionSource = NoRippleInteractionSource(),
                icon = {
                    Icon(
                        painter = painterResource(id = bottomNavItem.icon),
                        contentDescription = bottomNavItem.contentDescription,
                    )
                },
                label = {
                    Text(text = bottomNavItem.contentDescription)
                }
            )
        }
    }
}

