package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model

import androidx.annotation.DrawableRes
data class SpendingDetailGroupModel(
    val title: String,
    val label: String,
    val value: String
)

data class SpendingDetailPaymentModel(
    val mainInfo: SpendingDetailGroupModel,
    val amountInfo: SpendingDetailGroupModel,
    @DrawableRes val icon: Int
)

data class SpendingSummaryModel(
    val splitAmount: Long,
    val memo: String,
    val isIncludedInTotal: Boolean,
    val isSettlementComplete: Boolean
)

data class SpendingInfoModel(
    val orderAmount: Long,
    val paymentAmount: Long,
    val orderNumber: String,
    val dateTime: String,
    val category: String
)

data class SpendingDetailUiState(
    val paymentInfo: SpendingDetailPaymentModel,
    val summaryInfo: SpendingSummaryModel,
    val detailInfo: SpendingInfoModel
)