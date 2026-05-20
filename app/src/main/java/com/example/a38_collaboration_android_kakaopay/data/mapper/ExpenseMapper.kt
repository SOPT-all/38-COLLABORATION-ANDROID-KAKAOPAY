package com.example.a38_collaboration_android_kakaopay.data.mapper

import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.DailyTransactions
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseDetailResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.Transactions
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSummary
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionCategory
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailPaymentModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingInfoModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingSummaryModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.DailyTransactionsUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.SpendingOverviewUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.TransactionsUiModel
import kotlinx.collections.immutable.toImmutableList
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

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

fun ExpenseDetailResponse.toUiModel(): SpendingDetailUiModel {
    val displayCategory = when (this.category) {
        "DELIVERY" -> "배달"
        "TRANSPORTATION" -> "교통"
        "FOOD" -> "음식"
        "COFFEE_DESSERT" -> "커피/디저트"
        else -> this.category
    }

    val displayPaymentMethod = when (this.paymentMethod) {
        "CARD" -> "카드"
        "ACCOUNT" -> "계좌"
        "PAY_PAYMENT" -> "페이결제"
        "POINT" -> "포인트"
        "PAY_MONEY" -> "페이머니"
        "PAY_POINT" -> "페이포인트"
        else -> this.paymentMethod
    }

    return SpendingDetailUiModel(
        paymentInfo = SpendingDetailPaymentModel(
            expenseName = this.expenseName,
            paymentMethod = displayPaymentMethod,
            splitAmount = this.splitAmount,
            totalAmount = this.totalAmount,
            icon = this.toThumbnail()
        ),
        summaryInfo = SpendingSummaryModel(
            splitAmount = this.splitAmount,
            memo = "",
            isIncludedInTotal = this.includeInTotal,
            isSettlementComplete = this.participantCount > 1
        ),
        detailInfo = SpendingInfoModel(
            orderAmount = this.totalAmount,
            paymentAmount = this.splitAmount,
            orderNumber = this.orderNumber,
            dateTime = this.orderedAt.toDisplayDateTime(),
            category = displayCategory
        )
    )
}

private fun ExpenseDetailResponse.toThumbnail(): Int {
    return when (this.category) {
        "DELIVERY", "FOOD" -> R.drawable.img_baemin_logo_48px
        else -> R.drawable.img_profile_placeholder
    }
}

private fun String.toDisplayDateTime(): String {
    return runCatching {
        val localDateTime = LocalDateTime.parse(this)
        val formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd.(E) HH:mm", Locale.KOREAN)
        localDateTime.format(formatter)
    }.getOrDefault(this)
}