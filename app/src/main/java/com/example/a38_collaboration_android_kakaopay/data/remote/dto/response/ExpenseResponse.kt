package com.example.a38_collaboration_android_kakaopay.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExpenseResponse(
    @SerialName("year")
    val year: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("totalExpense")
    val totalExpense: Int,
    @SerialName("totalIncome")
    val totalIncome: Int,
    @SerialName("fixedExpense")
    val fixedExpense: Int,
    @SerialName("previousMonthTotal")
    val previousMonthTotal: Int,
    @SerialName("dailyTransactions")
    val dailyTransactions: List<DailyTransactions>
)

@Serializable
data class DailyTransactions(
    @SerialName("date")
    val date: String,
    @SerialName("dayOfWeek")
    val dayOfWeek: String,
    @SerialName("dailyTotal")
    val dailyTotal: Int,
    @SerialName("transactions")
    val transactions: List<Transactions>
)

@Serializable
data class Transactions(
    @SerialName("transactionId")
    val transactionId: Int,
    @SerialName("transactionType")
    val transactionType: String,
    @SerialName("transactionMethod")
    val transactionMethod: String,
    @SerialName("transactionName")
    val transactionName: String,
    @SerialName("category")
    val transactionCategory: String?,
    @SerialName("amount")
    val amount: Int,
    @SerialName("includeInTotal")
    val includeInTotal: Boolean?
)
