package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model

import androidx.annotation.DrawableRes

data class SpendingDetailPaymentModel(
    val productName: String,
    val paymentMethod: String,
    val paymentType: String,
    val paymentAmount: Long,
    val totalPaymentAmount: Long,
    @DrawableRes val icon: Int
)