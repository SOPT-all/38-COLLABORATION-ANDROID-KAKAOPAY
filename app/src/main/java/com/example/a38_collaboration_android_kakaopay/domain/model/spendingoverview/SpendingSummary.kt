package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview

import kotlin.math.abs

data class SpendingSummary(
    val totalExpense: Int,
    val totalIncome: Int,
    val fixedExpense: Int,
    val previousMonthTotal: Int,
) {
    val expenseDiff: Int get() = totalExpense - previousMonthTotal
    val expenseDiffInManWon: Int get() = abs(expenseDiff) / 10000
    val isOverSpent: Boolean get() = expenseDiff > 0
}