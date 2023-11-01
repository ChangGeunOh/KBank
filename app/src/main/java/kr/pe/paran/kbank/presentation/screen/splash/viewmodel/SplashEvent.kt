package kr.pe.paran.kbank.presentation.screen.splash.viewmodel

sealed class SplashEvent {
    data object OnNext: SplashEvent()
}