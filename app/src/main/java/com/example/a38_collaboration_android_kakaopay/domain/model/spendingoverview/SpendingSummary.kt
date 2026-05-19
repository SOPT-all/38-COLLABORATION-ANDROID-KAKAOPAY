package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview

data class SpendingSummary(
    val totalExpense: Int,
    val totalIncome: Int,
    val fixedExpense: Int,
    val previousMonthTotal: Int,
)