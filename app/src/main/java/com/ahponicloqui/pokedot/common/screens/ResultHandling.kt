package com.ahponicloqui.pokedot.common.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.ahponicloqui.pokedot.common.NetworkResult

@Composable
fun <T> State<NetworkResult<T>>.HandleResult(
    onError: @Composable (String?) -> Unit = { ErrorScreen() },
    onLoading: @Composable () -> Unit = { LoadingScreen() },
    onSuccess: @Composable (T) -> Unit,
) {
    when (val item = this.value) {
        is NetworkResult.Error -> onError(null)
        is NetworkResult.Loading -> onLoading()
        is NetworkResult.Success -> onSuccess(item.data)
    }
}