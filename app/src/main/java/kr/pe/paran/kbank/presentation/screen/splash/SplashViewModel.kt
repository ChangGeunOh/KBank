package kr.pe.paran.kbank.presentation.screen.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.pe.paran.kbank.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

}