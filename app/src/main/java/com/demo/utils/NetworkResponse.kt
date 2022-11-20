package com.demo.utils

import java.io.IOException

/*
 * Sealed calls for getting the network response and handling them
 */
sealed class NetworkResponse<out T : Any> {

    data class Success<T : Any>(val body: T)        : NetworkResponse<T>()

    data class ApiError(val body: String)           : NetworkResponse<String>()

    data class Loading(val body: String)           : NetworkResponse<String>()

    data class NetworkError(val error: IOException) : NetworkResponse<Nothing>()

}
