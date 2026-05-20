package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model

import androidx.annotation.DrawableRes
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat

data class SpendingDetailUiModel(
    val paymentInfo: SpendingDetailPaymentModel,
    val summaryInfo: SpendingSummaryModel,
    val detailInfo: SpendingInfoModel
)

data class SpendingDetailPaymentModel(
    val expenseName: String,
    val paymentMethod: String,
    val splitAmount: Long,
    val totalAmount: Long,
    @DrawableRes val icon: Int
) {
    val formattedSplitAmount: String get() = splitAmount.toWonFormat()
    val formattedTotalAmount: String get() = totalAmount.toWonFormat()
}

data class SpendingSummaryModel(
    val splitAmount: Long,
    val memo: String,
    val isIncludedInTotal: Boolean,
    val isSettlementComplete: Boolean
) {
    val formattedSplitAmount: String get() = splitAmount.toWonFormat()
}

data class SpendingInfoModel(
    val orderAmount: Long,
    val paymentAmount: Long,
    val orderNumber: String,
    val dateTime: String,
    val category: String
) {
    val formattedOrderAmount: String get() = orderAmount.toWonFormat()
    val formattedPaymentAmount: String get() = paymentAmount.toWonFormat()
}