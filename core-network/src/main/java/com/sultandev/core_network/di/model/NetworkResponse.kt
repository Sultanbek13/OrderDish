package com.sultandev.core_network.di.model

data class NetworkResponse<T>(val isSuccess: Boolean, val data: T, val error: String)