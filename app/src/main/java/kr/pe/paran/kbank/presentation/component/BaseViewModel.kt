package kr.pe.paran.kbank.presentation.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseViewModel<S, E>(private val initial: S) : ViewModel() {

    private val events = Channel<E>()
    val state =
        events.receiveAsFlow().runningFold(
            initial = initial,
            operation = ::reduceState,
        ).stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = initial,
        )

    abstract suspend fun reduceState(oldState: S, event: E): S

    fun onEvent(event: E) {
        viewModelScope.launch {
            events.send(event)
        }
    }

    private val _sideEvents = Channel<E>()
    val sideEvents = _sideEvents.receiveAsFlow()


    fun onSideEvent(event: E) {
        viewModelScope.launch {
            _sideEvents.send(event)
        }
    }


}