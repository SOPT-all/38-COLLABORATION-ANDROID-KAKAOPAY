package com.example.a38_collaboration_android_kakaopay.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpendingAnalysisResponse(
    @SerialName("monthlyCumulativeTotal")
    val monthlyCumulativeTotal: Long,

    @SerialName("previousMonthSamePeriodTotal")
    val previousMonthSamePeriodTotal: Long,

    @SerialName("categoryExpenses")
    val categoryExpenses: List<categoryExpenses>,
)

@Serializable
data class categoryExpenses(
    @SerialName("category")
    val category: String,

    @SerialName("currentMonthAmount")
    val currentMonthAmount: Long,

    @SerialName("previousMonthAmount")
    val previousMonthAmount: Long,
)
