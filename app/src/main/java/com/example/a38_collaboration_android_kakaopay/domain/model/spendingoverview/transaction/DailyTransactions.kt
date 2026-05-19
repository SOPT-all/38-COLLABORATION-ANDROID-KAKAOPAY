package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction

import kotlinx.collections.immutable.ImmutableList

data class DailyTransactions (
    val date: String,
    val dayOfWeek: String,
    val dailyTotal: Int,
    val transactions: ImmutableList<Transaction>
)