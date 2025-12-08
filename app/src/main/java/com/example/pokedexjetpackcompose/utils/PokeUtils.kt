package com.example.pokedexjetpackcompose.utils

fun String.extractLastNumberAndFormat(): String {
    val cleanUrl = this.trimEnd('/')
    val lastSegment = cleanUrl.substringAfterLast('/')
    val number = when(lastSegment.length) {
        1 -> "#00$lastSegment"
        2 -> "#0$lastSegment"
        3 -> "#${lastSegment}"
        else -> "#${lastSegment}"
    }
    return number
}

fun String.extractLastNumber(): String {
    val cleanUrl = this.trimEnd('/')
    val lastSegment = cleanUrl.substringAfterLast('/')

    return lastSegment
}

fun String.capitalizeFirst(): String {
    if (this.isEmpty()) return this
    return this[0].uppercase() + this.substring(1)
}
