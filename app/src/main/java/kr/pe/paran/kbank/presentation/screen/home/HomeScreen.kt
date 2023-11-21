package kr.pe.paran.kbank.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.pe.paran.kbank.R
import kr.pe.paran.kbank.presentation.screen.home.component.CardItem
import kr.pe.paran.kbank.presentation.screen.home.component.CardTitle
import kr.pe.paran.kbank.presentation.screen.home.component.HomeTopBar
import kr.pe.paran.kbank.presentation.screen.home.viewmodel.HomeEvent
import kr.pe.paran.kbank.presentation.screen.home.viewmodel.HomeViewModel
import kr.pe.paran.kbank.ui.theme.MainBackgroundColor
import kr.pe.paran.kbank.ui.theme.TitleTextColor

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = state.nextScreen, block = {
        state.nextScreen?.let {
            navController.navigate(it.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
    })

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBackgroundColor)
            .padding(horizontal = 20.dp),
        containerColor = Color.Transparent,
        contentColor = TitleTextColor,
        topBar = {
            HomeTopBar(
                onClick = { viewModel.onEvent(HomeEvent.OnClick(it)) }
            )
        }
    ) { paddingValues ->
        HomeContent(
            paddingValues = paddingValues,
            onEvent = viewModel::onEvent,
            state = state
        )
    }
}

@Preview
@Composable
fun CreditCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(corner = CornerSize(14.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
        ) {
            CardTitle(title = "다른은행")
            Spacer(modifier = Modifier.height(16.dp))
            CardItem(
                iconId = R.drawable.ic_card_kbank,
                accountName = "KT멤버십더블혜택",
                balance = 290334
            )
            Spacer(modifier = Modifier.height(16.dp))
            CardItem(
                iconId = R.drawable.ic_card_kbank,
                accountName = "KT멤버십더블혜택",
                balance = 290334,
                text = "이체"
            )
        }
    }
}

