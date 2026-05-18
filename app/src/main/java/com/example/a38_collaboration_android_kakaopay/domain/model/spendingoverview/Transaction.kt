package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview

import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.TransactionType

data class Transaction (
    val transactionId: Int,
    val transactionType: TransactionType,
    val transactionMethod: TransactionMethod,
    val transactionName: String,
    val amount: Int,
    val includeInTotal: Boolean,
)