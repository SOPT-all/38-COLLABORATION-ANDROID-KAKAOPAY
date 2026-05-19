package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction

data class Transaction (
    val transactionId: Int,
    val transactionType: TransactionType,
    val transactionMethod: TransactionMethod,
    val transactionName: String,
    val amount: Int,
    val includeInTotal: Boolean,
)