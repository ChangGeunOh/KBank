package kr.pe.paran.kbank.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.pe.paran.kbank.presentation.screen.home.component.AccountCard
import kr.pe.paran.kbank.presentation.screen.home.component.AdCard
import kr.pe.paran.kbank.presentation.screen.home.component.GroupAccountCard
import kr.pe.paran.kbank.presentation.screen.home.component.OtherBankCard
import kr.pe.paran.kbank.presentation.screen.home.viewmodel.HomeEvent
import kr.pe.paran.kbank.presentation.screen.home.viewmodel.HomeState

@Composable
fun HomeContent(
    paddingValues: PaddingValues,
    state: HomeState,
    onEvent: (HomeEvent) -> Unit = {},
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize(),

        verticalArrangement = Arrangement.spacedBy(space = 20.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AdCard(
//                adData = state.adData,
//                onClick = { onEvent(MainEvent.OnClick(it)) }
            )
        }
        item {
            GroupAccountCard(
//                accountDataList = state.accountDataList,
//                onClick = { onEvent(MainEvent.OnClick(it)) }
            )
        }
        item {
            AccountCard(
//                accountData = state.accountData,
//                onClick = { onEvent(MainEvent.OnClick(it)) }
            )
        }
        item {
            OtherBankCard(
//                cardData = state.cardData,
//                onClick = { onEvent(MainEvent.OnClick(it)) }
            )
        }
        item {
            Spacer(modifier = Modifier.padding(top = 20.dp))
        }
    }
}