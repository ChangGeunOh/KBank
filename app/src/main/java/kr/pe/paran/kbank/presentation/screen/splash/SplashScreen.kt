package kr.pe.paran.kbank.presentation.screen.splash

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.pe.paran.kbank.navigation.Screen
import kr.pe.paran.kbank.presentation.screen.splash.viewmodel.SplashEvent
import kr.pe.paran.kbank.presentation.screen.splash.viewmodel.SplashViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = state, block = {
        if (state.isNext) {
            navController.navigate(Screen.Main.route)
        }
    })

    LaunchedEffect(key1 = Unit, block = {
        CoroutineScope(coroutineContext).launch {
            delay(2000)
            viewModel.onEvent(SplashEvent.OnNext)
        }
    })

    Scaffold { paddingValues ->
        SplashContent(
            innerPadding = paddingValues,
            state = state,
        )
    }
}


