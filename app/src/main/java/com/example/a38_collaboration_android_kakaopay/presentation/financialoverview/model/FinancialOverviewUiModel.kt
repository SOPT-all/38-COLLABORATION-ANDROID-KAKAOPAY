package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model

data class FinancialOverviewUiModel(
    val kakaopayBalance: Long,
    val favoriteAccounts: List<FavoriteAccounts>,
    val totalExpense: Long,
)

data class FavoriteAccounts(
    val accountId: Long,
    val accountInfo: String,
)
