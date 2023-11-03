package kr.pe.paran.kbank.presentation.screen.login.viewmodel

import kr.pe.paran.kbank.domain.model.AuthType

sealed class LoginEvent {
    data class OnClickKeyPad(val number: String) : LoginEvent()
    data object OnNext: LoginEvent()
    data object OnClickOther: LoginEvent()
    data object OnShowKeyPad: LoginEvent()
    data object OnClose: LoginEvent()
    data class OnClickAuthType(val authType: AuthType): LoginEvent()
    data class OnClickOtherAuth(val otherAuthEvent: OtherAuthEvent): LoginEvent()
    data object OnClearPassword: LoginEvent()
}


enum class OtherAuthEvent {
    BioAuth,
    CertAuth,
    PassAuth,
    Close,
    Help,
}