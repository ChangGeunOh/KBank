package kr.pe.paran.kbank.presentation.screen.splash.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import kr.pe.paran.kbank.domain.use_case.UseCases
import kr.pe.paran.kbank.presentation.component.BaseViewModel
import kr.pe.paran.kbank.presentation.screen.splash.viewmodel.SplashEvent
import kr.pe.paran.kbank.presentation.screen.splash.viewmodel.SplashState
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases,
) : BaseViewModel<SplashState, SplashEvent>(SplashState()) {
    override suspend fun reduceState(oldState: SplashState, event: SplashEvent): SplashState {
        return when(event) {
            is SplashEvent.OnNext -> {
                oldState.copy(isNext = true, isLoading = false)
            }

        }
    }


}