package com.example.a38_collaboration_android_kakaopay.core.common.util

import java.text.NumberFormat
import java.util.Locale

fun Long.toCommaFormat(): String {
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
    return formatter.format(this)
}

fun Int.toCommaFormat(): String {
    return this.toLong().toCommaFormat()
}

fun String.toCommaFormat(): String {
    val number = this
        .replace(",", "")
        .trim()
        .toLongOrNull()

    return number?.toCommaFormat() ?: this
}

fun Long.toWonFormat(): String {
    return "${this.toCommaFormat()}원"
}

fun Int.toWonFormat(): String {
    return this.toLong().toWonFormat()
}

fun String.toWonFormat(): String {
    val number = this
        .replace(",", "")
        .trim()
        .toLongOrNull()

    return number?.toWonFormat() ?: this
}
