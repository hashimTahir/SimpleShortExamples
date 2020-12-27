/*
 * Copyright (c) 2020/  12/ 27.  Created by Hashim Tahir
 */

package com.hashim.simpleshortexamples.stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class StateFlowViewModel : ViewModel() {
    private val hLoginUiStateMSF = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val hLoginUiStateSF: StateFlow<LoginUiState> = hLoginUiStateMSF


    fun hLoginUser(userName: String, password: String) =
        viewModelScope.launch {
            Timber.d("Username %s ,  Password %s ", userName, password)
            hLoginUiStateMSF.value = LoginUiState.Loading
            delay(2000L)

            if (userName.equals("android") && password.equals("hashim")) {
                hLoginUiStateMSF.value = LoginUiState.Success
            } else {
                hLoginUiStateMSF.value = LoginUiState.Error("Invalid")

            }
        }


    sealed class LoginUiState {

        object Success : LoginUiState()
        object Empty : LoginUiState()
        object Loading : LoginUiState()
        data class Error(
            val message: String
        ) : LoginUiState()
    }
}