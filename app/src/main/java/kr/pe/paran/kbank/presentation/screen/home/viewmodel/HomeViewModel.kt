package kr.pe.paran.kbank.presentation.screen.home.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import kr.pe.paran.kbank.common.CARD_DATA_LIST
import kr.pe.paran.kbank.domain.use_case.UseCases
import kr.pe.paran.kbank.presentation.component.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases,
) : BaseViewModel<HomeState, HomeEvent>(HomeState()) {
    override suspend fun reduceState(oldState: HomeState, event: HomeEvent): HomeState {
        when (event) {
            is HomeEvent.OnClick -> {
                oldState.copy(
                    nextScreen = null,
                )
            }

            is HomeEvent.OnCardDataList -> {
                oldState.copy(
                    cardDataList = event.cardDataList,
                )
            }
        }.also { return it }
    }

    init {
        onEvent(HomeEvent.OnCardDataList(CARD_DATA_LIST))
    }
}