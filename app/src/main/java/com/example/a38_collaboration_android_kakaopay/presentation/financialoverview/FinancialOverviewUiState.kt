package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview

import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialList
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FavoriteAccounts
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class FinancialOverviewUiState(
    val kakaopayBalance: Long = 0L,
    val totalExpense: Long = 0L,
    val favoriteAccounts: ImmutableList<FinancialList> = persistentListOf(),
)
