package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model

data class FinancialOverviewUiModel(
    val kakaopayBalance: Long,
    val favoriteAccounts: List<FavoriteAccountUiModel>,
    val totalExpense: Long,
)

data class FavoriteAccountUiModel(
    val accountId: Long,
    val accountInfo: String,
)
