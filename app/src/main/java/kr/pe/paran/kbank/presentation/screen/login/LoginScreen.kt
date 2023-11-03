package kr.pe.paran.kbank.presentation.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kr.pe.paran.kbank.navigation.Screen
import kr.pe.paran.kbank.presentation.screen.login.component.OtherLoginContent
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.LoginEvent
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.LoginState
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.LoginViewModel
import kr.pe.paran.kbank.presentation.screen.login.viewmodel.OtherAuthEvent
import kotlin.reflect.KFunction1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(key1 = state.nextScreen, block = {

        state.nextScreen?.let {
            if (it != Screen.Test)
                navController.navigate(it.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
        }
    })


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) { innerPadding ->

        LoginContent(
            innerPadding = innerPadding,
            state = state,
            onEvent = viewModel::onEvent,
        )

    }

    if (state.isShowBottomSheet) {
        ModalBottomSheet(
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            dragHandle = {},
            sheetState = sheetState,
            containerColor = Color.White,
            contentColor = Color.Black,
            onDismissRequest = {
                viewModel.onEvent(LoginEvent.OnClickOtherAuth(otherAuthEvent = OtherAuthEvent.Close))
            }
        ) {
            OtherLoginContent(
                onEvent = {
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                    viewModel.onEvent(it)
                }
            )
        }
    }


}

