package com.example.a38_collaboration_android_kakaopay.data.mapper

import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.DailyTransactions
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.Transactions
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSummary
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionCategory
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.DailyTransactionsUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.SpendingOverviewUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.TransactionsUiModel
import kotlinx.collections.immutable.toImmutableList

fun ExpenseResponse.toUiModel(): SpendingOverviewUiModel {
    return SpendingOverviewUiModel(
        spendingSummary = SpendingSummary(
            totalExpense = totalExpense,
            totalIncome = totalIncome,
            fixedExpense = fixedExpense,
            previousMonthTotal = previousMonthTotal
        ),
        dailyTransactions = dailyTransactions.map { it.toUiModel() }
    )
}

fun DailyTransactions.toUiModel(): DailyTransactionsUiModel {
    return DailyTransactionsUiModel (
        date = date,
        dayOfWeek = dayOfWeek,
        dailyTotal = dailyTotal,
        transactions = transactions.map { it.toUiModel() }.toImmutableList()
    )
}

fun Transactions.toUiModel(): TransactionsUiModel {
    return TransactionsUiModel (
        transactionId = transactionId,
        transactionType = TransactionType.valueOf(transactionType),
        transactionMethod = TransactionMethod.valueOf(transactionMethod),
        transactionName = transactionName,
        amount = amount,
        includeInTotal = includeInTotal ?: true,
        thumbnail = toThumbnail()
    )
}

private const val KAKAOBANK_KEYWORD = "카카오뱅크"

private fun Transactions.toThumbnail(): Int {
    val type = TransactionType.valueOf(transactionType)
    val category = transactionCategory?.let { TransactionCategory.valueOf(it) }

    return when (type) {
        TransactionType.PAYMENT -> when (category) {
            TransactionCategory.TRANSPORTATION -> R.drawable.img_transport
            TransactionCategory.COFFEE_DESSERT -> R.drawable.img_cafe
            TransactionCategory.FOOD -> R.drawable.img_food
            else -> R.drawable.img_profile_placeholder
        }

        else -> when {
            transactionName.contains(KAKAOBANK_KEYWORD) -> R.drawable.img_kakaopay_logo
            else -> R.drawable.img_profile_placeholder
        }
    }
}