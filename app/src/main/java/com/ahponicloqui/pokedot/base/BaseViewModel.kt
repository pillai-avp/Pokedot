package com.ahponicloqui.pokedot.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseViewModel<E> : ViewModel() {
    private val _uiEvent = MutableSharedFlow<E>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun sendEvent(event: E) {
        viewModelScope.launch {
            _uiEvent.emit(event)
            handleEvent(event)
        }
    }

    protected open fun handleEvent(event: E) {}

    fun <T> Flow<T>.asState(initialValue: T): StateFlow<T> {
        return this.stateIn(viewModelScope, SharingStarted.Eagerly, initialValue)
    }
}