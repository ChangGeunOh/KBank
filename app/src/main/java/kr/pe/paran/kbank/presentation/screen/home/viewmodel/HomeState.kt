package kr.pe.paran.kbank.presentation.screen.home.viewmodel

import kr.pe.paran.kbank.domain.model.CardData
import kr.pe.paran.kbank.navigation.Screen

data class HomeState(
    val nextScreen: Screen? = null,
    val cardDataList: List<CardData> = emptyList(),
)
