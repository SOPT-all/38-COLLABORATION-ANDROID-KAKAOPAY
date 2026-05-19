package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction

data class DailyTransactions (
    val date: String,
    val dayOfWeek: String,
    val dailyTotal: Int,
    val transactions: List<Transaction>
)