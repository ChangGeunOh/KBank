package kr.pe.paran.kbank.presentation.screen.login.viewmodel

import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.pe.paran.kbank.common.Constants
import kr.pe.paran.kbank.common.utils.Logcat
import kr.pe.paran.kbank.domain.use_case.UseCases
import kr.pe.paran.kbank.navigation.Screen
import kr.pe.paran.kbank.presentation.component.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: UseCases,
) : BaseViewModel<LoginState, LoginEvent>(LoginState()) {
    override suspend fun reduceState(oldState: LoginState, event: LoginEvent): LoginState {
        Logcat.i("oldState: $oldState :: event: $event")
        when (event) {
            is LoginEvent.OnClickKeyPad -> {
                var password = oldState.password
                Logcat.i("1. password: ${oldState.password} :: event: ${event.number}")
                if (oldState.password.length < 6) {
                    when (event.number) {
                        "back" -> password = password.dropLast(1)
                        "face" -> password = ""
                        else -> password += event.number
                    }
                }
                if (password.length == 6) {
                    viewModelScope.launch {
                        delay(500)
                        if (password == Constants.PASSWORD_NUMBER) {
                            onEvent(LoginEvent.OnNext)
                        } else {
                            onEvent(LoginEvent.OnClearPassword)
                        }
                    }
                }
                Logcat.i("2. password: $password :: event: ${event.number}")
                return oldState.copy(password = password)
            }

            LoginEvent.OnNext -> {
                return oldState.copy(nextScreen = Screen.Main)
            }

            LoginEvent.OnClickOther -> {
                return oldState.copy(isShowKeyPad = false, isShowBottomSheet = true)
            }

            LoginEvent.OnShowKeyPad -> {
                return oldState.copy(isShowKeyPad = true)
            }

            LoginEvent.OnClose -> {
                return oldState.copy(isShowKeyPad = true)
            }

            is LoginEvent.OnClickAuthType -> {
                return oldState
            }

            is LoginEvent.OnClickOtherAuth -> {
                return when (event.otherAuthEvent) {
                    OtherAuthEvent.BioAuth -> {
                        oldState.copy(nextScreen = Screen.Test, isShowBottomSheet = false)
                    }

                    OtherAuthEvent.CertAuth -> {
                        oldState.copy(nextScreen = Screen.Test, isShowBottomSheet = false)

                    }

                    OtherAuthEvent.PassAuth -> {
                        oldState.copy(nextScreen = Screen.Test, isShowBottomSheet = false)
                    }

                    OtherAuthEvent.Close -> {
                        oldState.copy(isShowKeyPad = true, isShowBottomSheet = false)
                    }

                    OtherAuthEvent.Help -> {
                        oldState.copy(nextScreen = Screen.Test, isShowBottomSheet = false)
                    }
                }
            }

            LoginEvent.OnClearPassword -> {
                return oldState.copy(password = "")
            }
        }
    }

}