package kr.pe.paran.kbank.presentation.screen.home.viewmodel

import kr.pe.paran.kbank.domain.model.ButtonType
import kr.pe.paran.kbank.domain.model.CardData

sealed class HomeEvent {
    data class OnClick(val buttonType: ButtonType) : HomeEvent()
    data class OnCardDataList(val cardDataList: List<CardData>) : HomeEvent()
}

//enum class MainClickType {
//    CHUL_CHECK,
//    BENEFITS,
//    AD_CARD,
//    AD_CLOSE,
//}