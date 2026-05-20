package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model

import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSummary
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import kotlinx.collections.immutable.ImmutableList

data class SpendingOverviewUiModel (
    val spendingSummary: SpendingSummary,
    val dailyTransactions: List<DailyTransactionsUiModel>
)

data class DailyTransactionsUiModel (
    val date: String,
    val dayOfWeek: String,
    val dailyTotal: Int,
    val transactions: ImmutableList<TransactionsUiModel>
) {
    val formattedDailyTotal: String get() =
        if (dailyTotal > 0) "+${dailyTotal.toWonFormat()}" else dailyTotal.toWonFormat()
}

data class TransactionsUiModel (
    val transactionId: Int,
    val transactionType: TransactionType,
    val transactionMethod: TransactionMethod,
    val transactionName: String,
    val amount: Int,
    val includeInTotal: Boolean,
    val thumbnail: Int,
)