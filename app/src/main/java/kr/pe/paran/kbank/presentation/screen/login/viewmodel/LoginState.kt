package kr.pe.paran.kbank.presentation.screen.login.viewmodel

import kr.pe.paran.kbank.domain.model.AuthType
import kr.pe.paran.kbank.navigation.Screen

data class LoginState(
    val password: String = "",
    val nextScreen: Screen? = null,
    val isShowKeyPad: Boolean = true,
    val isShowBottomSheet: Boolean = false,
)
