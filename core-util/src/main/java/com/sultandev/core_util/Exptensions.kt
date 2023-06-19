package com.sultandev.core_util

fun String.toRub(): String {
    return "$this ₽"
}

fun String.toWight(): String {
    return "·$this" + "г"
}