package com.example.a38_collaboration_android_kakaopay.data.mapper

import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseDetailResponse
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailPaymentModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingInfoModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingSummaryModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

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
    }.getOrDefault(this) // 혹시 파싱 에러나면 앱 터트리지 말고 날것의 데이터라도 안전하게 보여주기 방어막
}