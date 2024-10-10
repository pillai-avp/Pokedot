package com.ahponicloqui.pokedot.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import retrofit2.Response

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>
    data class Error(val exception: Throwable? = null, val errorCode: Int? = null) : NetworkResult<Nothing>
    data object Loading : NetworkResult<Nothing>
}

fun <T> asResult(
    retrofitCall: suspend () -> Response<T>
): Flow<NetworkResult<T>> {
    return flow<NetworkResult<T>> {
        val response = retrofitCall.invoke()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(NetworkResult.Success(it))
            } ?: throw Exception("failed: Empty response body")
        } else {
            emit(
                NetworkResult.Error(
                    Exception(response.errorBody()?.string()),
                    errorCode = response.code()
                )
            )
        }
    }.onStart { emit(NetworkResult.Loading) }.catch {
        emit(NetworkResult.Error(it))
    }
}