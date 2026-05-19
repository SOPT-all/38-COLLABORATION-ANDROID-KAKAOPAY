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