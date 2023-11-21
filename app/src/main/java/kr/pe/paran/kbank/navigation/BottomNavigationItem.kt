package kr.pe.paran.kbank.navigation

data class BottomNavigationItem(
    val route: String,
    val icon: Int,
    val contentDescription: String = "",
)
