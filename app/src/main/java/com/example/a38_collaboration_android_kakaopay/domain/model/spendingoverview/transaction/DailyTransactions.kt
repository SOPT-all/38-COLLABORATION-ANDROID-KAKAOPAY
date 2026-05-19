package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction

import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import kotlinx.collections.immutable.ImmutableList

data class DailyTransactions (
    val date: String,
    val dayOfWeek: String,
    val dailyTotal: Int,
    val transactions: ImmutableList<Transaction>
) {
    val formattedDailyTotal: String get() =
        if (dailyTotal > 0) "+${dailyTotal.toWonFormat()}" else dailyTotal.toWonFormat()
}